ThisBuild / name := "s3mock"
ThisBuild / organization := "io.chris-kipp"
ThisBuild / scalaVersion := "2.13.12"
ThisBuild / licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT"))
ThisBuild / homepage := Some(url("https://github.com/ckipp01/s3mock"))
ThisBuild / developers := List(
  Developer(
    "ckipp01",
    "Chris Kipp",
    "open-source@chris-kipp.io",
    url("https://chris-kipp.io")
  )
)
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

lazy val pekkoVersion = "1.0.2"

ThisBuild / libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
  "org.apache.pekko" %% "pekko-http" % "1.0.0",
  "org.apache.pekko" %% "pekko-stream-testkit" % pekkoVersion % Test,
  "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
  "org.scala-lang.modules" %% "scala-collection-compat" % "2.5.0",
  "com.github.pathikrit" %% "better-files" % "3.9.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.12.650",
  "org.scalatest" %% "scalatest" % "3.2.9" % Test,
  "ch.qos.logback" % "logback-classic" % "1.4.14" % Test,
  "org.iq80.leveldb" % "leveldb" % "0.12",
  "org.apache.pekko" %% "pekko-connectors-s3" % pekkoVersion % Test,
  "javax.xml.bind" % "jaxb-api" % "2.3.1",
  "com.sun.xml.bind" % "jaxb-core" % "3.0.1",
  "com.sun.xml.bind" % "jaxb-impl" % "3.0.1",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0" % Test
)

Test / parallelExecution := false
