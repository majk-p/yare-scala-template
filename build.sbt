import Dependencies._
import org.scalajs.linker.interface.ModuleInitializer

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "net.michalp" // change me
ThisBuild / organizationName := "yare-scala-template" // change me

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "yare-scala-template",
    libraryDependencies ++= dependencies,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.NoModule)
    }
  )

lazy val buildStrategy =
  taskKey[Unit]("Generate the strategy js file in ./target/yare-bundle/")

buildStrategy := {
  val log = streams.value.log
  log.info("Cleaning the workspace")
  clean.value
  val output = (Compile / fullLinkJS / scalaJSLinkerOutputDirectory).value
  log.info("Triggering the scala.js build")
  (Compile / fullLinkJS).value
  val destination = (ThisBuild / baseDirectory).value / "target" / "yare-bundle"
  val filesToCopy = IO.listFiles(output).filter(_.ext == "js")

  if (destination.exists()) {
    log.info("Performing target destination cleanup")
    val filesToDelete = IO.listFiles(destination).filter(_.ext == "js")
    filesToDelete.foreach { f =>
      log.info(s"Deleting $f")
    }
  }

  filesToCopy.foreach { from =>
    log.info("Moving files to the destination directory")
    val to = destination / from.name
    log.info(s"Copying $from to $to")
    IO.copyFile(from, to)
  }
}
