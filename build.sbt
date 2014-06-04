import SonatypeKeys._

releaseSettings

// Import default settings. This changes `publishTo` settings to use the Sonatype repository and add several commands for publishing.
sonatypeSettings

name := "activator-gilt-lib"

organization := "com.gilt"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.10.4", "2.11.1")

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "ch.qos.logback" % "logback-classic" % "1.1.2" % "test",
  "org.scalatest" %% "scalatest" % "2.1.5" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gilt/activator-gilt-lib/master/LICENSE"))

homepage := Some(url("https://github.com/gilt/activator-gilt-lib"))

scmInfo := Some(ScmInfo(url("https://github.com/gilt/activator-gilt-lib.git"), "scm:git:git@github.com:gilt/activator-gilt-lib.git"))

pomExtra := 
  <developers>
    <developer>
      <id>gilt</id>
      <name>Gilt Groupe</name>
      <url>https://github.com/gilt</url>
    </developer>
  </developers>

lazy val publishSignedAction = { st: State =>
  val extracted = Project.extract(st)
  val ref = extracted.get(thisProjectRef)
  extracted.runAggregated(com.typesafe.sbt.pgp.PgpKeys.publishSigned in Global in ref, st)
}

import sbtrelease._
import ReleaseStateTransformations._

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts.copy(action = publishSignedAction),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
