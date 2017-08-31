name := "psd.scala.js"
organization := "com.outr"
version := "3.2.0"

scalaVersion := "2.12.3"
crossScalaVersions := List("2.12.3", "2.11.11", "2.13.0-M1")

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.3"

jsDependencies += ProvidedJS / "psd.js"
skip in packageJSDependencies := false

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)