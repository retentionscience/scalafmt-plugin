lazy val root = (project in file("."))
  .settings(
    name := "scalafmt-plugin",
    organization := "com.retentionscience",
    version := "0.0.1",
    description := "An SBT plugin for pulling the latest .scalafmt.conf file",
    sbtVersion := {
      scalaVersion.value match {
        case version if version.startsWith("2.12") => "1.2.8"
        case _ => "0.13.18" // current not executing the plugin task
      }
    },
    crossScalaVersions := Seq("2.10.7", "2.12.8"),
    crossSbtVersions := Seq("0.13.18", "1.2.8"),
    sbtPlugin := true,
    publishMavenStyle := true,
    publishTo := {
      val nexus = "http://ci.wajao.com:8081/nexus/"
      if (isSnapshot.value) {
        Some("snapshots" at nexus + "content/repositories/snapshots")
      } else {
        Some("releases" at nexus + "content/repositories/releases")
      }
    },
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )
