name := "scalafmt-plugin"

version := "0.0.1"

scalaVersion := "2.12.8"

sbtPlugin := true

publishMavenStyle := true

publishTo := {
  val nexus = "http://ci.wajao.com:8081/nexus/"
  if (isSnapshot.value) {
    Some("snapshots" at nexus + "content/repositories/snapshots")
  } else {
    Some("releases" at nexus + "content/repositories/releases")
  }
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
