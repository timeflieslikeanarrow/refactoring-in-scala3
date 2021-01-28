val scala3Version = "3.0.0-M3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "refactoring",
    version := "1.0.0",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalatest" % "scalatest_3.0.0-M3" % "3.2.3" % Test
  )
