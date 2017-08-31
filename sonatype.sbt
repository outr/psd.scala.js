sonatypeProfileName := "com.outr"
publishMavenStyle := true
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
homepage := Some(url("https://github.com/outr/scalajs-pixijs"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/outr/scalajs-pixijs"),
    "scm:git@github.com:outr/scalajs-pixijs.git"
  )
)
developers := List(
  Developer(id="darkfrog", name="Matt Hicks", email="matt@outr.com", url=url("http://matthicks.com"))
)