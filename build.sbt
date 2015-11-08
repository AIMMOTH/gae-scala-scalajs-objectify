enablePlugins(ScalaJSPlugin)

name := "SBT for Scala.js build"

scalaVersion := "2.10.5" // Must use 2.10.x and Java 7 to work with GAE

scalaSource in Compile := baseDirectory.value / "src" / "main" / "scalajs"

val jsDir = "src/main/webapp" // Output dir for JavaScript generation

crossTarget in (Compile, fastOptJS) := file(jsDir)
