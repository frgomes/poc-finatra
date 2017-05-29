name := "poc-finatra"
organization := "myorg"

scalaVersion := "2.11.8"

lazy val versions = new {
  val finatra    = "2.10.0"
  val guice      = "4.0"
  val logback    = "1.1.7"
  val junit      = "4.12"
  val mockito    = "1.9.5"
  val scalacheck = "1.13.4"
  val scalatest  = "3.0.0"
  val specs2     = "2.4.17"
  val utest      = "0.4.7"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

parallelExecution in ThisBuild := false

doctestWithDependencies := true
doctestMarkdownEnabled := true
doctestTestFramework := DoctestTestFramework.utest
testFrameworks += new TestFramework("utest.runner.Framework")


libraryDependencies ++= Seq(
  "com.twitter"    %% "finatra-http"       % versions.finatra,
  "com.twitter"    %% "finatra-httpclient" % versions.finatra,
  "ch.qos.logback" % "logback-classic"     % versions.logback,

  "com.twitter" %% "finatra-http"    % versions.finatra % "test",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test",
  "com.twitter" %% "inject-server"   % versions.finatra % "test",
  "com.twitter" %% "inject-app"      % versions.finatra % "test",
  "com.twitter" %% "inject-core"     % versions.finatra % "test",
  "com.twitter" %% "inject-modules"  % versions.finatra % "test",

  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter" %% "finatra-http"    % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-server"   % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-app"      % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-core"     % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-modules"  % versions.finatra % "test" classifier "tests",

  "org.mockito"    %  "mockito-core" % versions.mockito    % "test",
  "junit"          % "junit"         % versions.junit      % "test",
  "com.lihaoyi"    %% "utest"        % versions.utest      % "test",
  "org.scalacheck" %% "scalacheck"   % versions.scalacheck % "test",
  "org.scalatest"  %% "scalatest"    % versions.scalatest  % "test",
  "org.specs2"     %% "specs2-mock"  % versions.specs2     % "test")
