lazy val root = (project in file("."))
  .settings(
    sbtPlugin := true,
    name := "scalafmt-plugin",
    organization := "com.retentionscience",
    version := "0.0.1",
    description := "An SBT plugin for pulling the latest .scalafmt.conf file",
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
