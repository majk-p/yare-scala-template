import Dependencies._

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "net.michalp" // change me
ThisBuild / organizationName := "yare-scala-template" // change me

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "yare-scala-template",
    libraryDependencies ++= dependencies,
    scalaJSUseMainModuleInitializer := true
  )
