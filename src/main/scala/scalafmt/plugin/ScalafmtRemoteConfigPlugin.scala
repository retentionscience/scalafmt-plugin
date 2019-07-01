package scalafmt.plugin

import sbt.Keys.{ streams, update }
import sbt._

object ScalafmtRemoteConfigPlugin extends AutoPlugin {

  override def trigger = allRequirements

  object autoImport {
    lazy val remoteScalafmtConfig =
      taskKey[Unit]("Fetch .scalafmt from external repository")
  }

  import autoImport._
  
  override def projectSettings = Seq(
    remoteScalafmtConfig := remoteScalafmtConfigImpl.value,
    update in Compile := (update in Compile)
      .dependsOn(remoteScalafmtConfig)
      .value
  )

  private def remoteScalafmtConfigImpl = Def.task {
    import scala.sys.process._

    streams.value.log
      .info("Downloading .scalafmt config from remote repository...")
    val remoteScalafmtFile =
      "https://raw.githubusercontent.com/retentionscience/scalafmt-plugin/master/.scalafmt.conf"
    val baseDir = System.getProperty("user.dir")
    url(s"$remoteScalafmtFile") #> file(s"$baseDir/.scalafmt.conf") !
  }

}
