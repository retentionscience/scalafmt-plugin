addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.11")

// SBT Bloop
resolvers += Resolver.sonatypeRepo("snapshots")
addSbtPlugin("ch.epfl.scala" % "sbt-bloop" % "1.4.0-RC1+33-dfd03f53")
