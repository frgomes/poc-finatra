lazy val root = (project in file(".")).dependsOn(doctestPlugin)
lazy val doctestPlugin = uri("git://github.com/frgomes/sbt-doctest#issue_78-support_for_utest")

//TODO: addSbtPlugin("com.github.tkawachi" % "sbt-doctest"  % "0.5.1-SNAPSHOT")
