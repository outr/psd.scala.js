name := "psd.scala.js"
organization := "com.outr"
version := "3.1.0"

scalaVersion := "2.12.2"
crossScalaVersions := List("2.12.2", "2.11.11")

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.2"

jsDependencies += ProvidedJS / "psd.js"
skip in packageJSDependencies := false