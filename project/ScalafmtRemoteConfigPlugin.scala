import sbt.Keys._
import sbt._

object ScalafmtRemoteConfigPlugin extends AutoPlugin {

  object autoImport {
    lazy val remoteScalafmtConfig =
      taskKey[Unit]("Fetch .scalafmt from external repository")
  }

  import autoImport._
  override lazy val projectSettings = Seq(
    remoteScalafmtConfig := remoteScalafmtConfigImpl.value,
    compile in Compile := (compile in Compile)
      .dependsOn(remoteScalafmtConfig)
      .value
  )

  lazy val remoteScalafmtConfigImpl = Def.task {
    import scala.sys.process._

    streams.value.log
      .info("Downloading .scalafmt config from remote repository...")
    val remoteScalafmtFile =
      "https://raw.githubusercontent.com/retentionscience/scalafmt-plugin/master/.scalafmt.conf"
    val baseDir = (Compile / baseDirectory).value
    url(s"$remoteScalafmtFile") #> (baseDir / ".scalafmt.conf") !
  }

}
