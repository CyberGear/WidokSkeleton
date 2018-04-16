import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.name
import sbt.Keys.organization
import sbt.Keys.scalaVersion
import sbt.Keys.scalacOptions
import sbt.Keys.version
import src.main.scala.utils.Git

object Configuration {

  lazy val commonSettings = Seq(

    organization := "com.sceleton",
    name := "app",
    version := s"0.1.${Git.commitCount}",

    scalaVersion := "2.11.12",
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps"
    )
  )

  lazy val release: Boolean = sys.props.getOrElse("release", "false") == "true"
  lazy val jsDependencies: String = "dependencies.js"
  lazy val jsApplication: String = "application.js"

  lazy val clientDependencies = Def.setting(Seq(
    "io.github.widok" %%% "widok" % "0.2.4" withSources() withJavadoc()
  ))

  lazy val serverDependencies = Def.setting(Seq(
    "com.typesafe.akka" %% "akka-http" % "10.1.0",
    "com.typesafe.akka" %% "akka-actor" % "2.5.11",
    "com.typesafe.akka" %% "akka-stream" % "2.5.11"
  ))

  lazy val sharedDependencies = Def.setting(Seq(
    "com.lihaoyi" %%% "upickle" % "0.6.5",
    "com.lihaoyi" %%% "autowire" % "0.2.5",
    "com.lihaoyi" %%% "scalatags" % "0.6.7"
  ))

}
//lazy val server = crossProject.jvm
//  .settings(
//    scalaVersion := "2.11.11",
//    libraryDependencies ++= Seq(
//      "com.lihaoyi" %% "upickle" % "0.2.8",
//      "com.lihaoyi" %% "autowire" % "0.2.5",
//      "net.sf.extjwnl" % "extjwnl" % "1.8.1",
//      "net.sf.extjwnl" % "extjwnl-data-wn31" % "1.2"
//    ),
//    baseDirectory in reStart := new File("."),
//    reStart := reStart.dependsOn(optLevel in (client, Compile)).evaluated,
//    reStartArgs := Seq(port.toString),
//    mainClass := Some("io.widok.server.Server")
//  )

//lazy val client = crossProject.js
//  .disablePlugins(RevolverPlugin)
//  .settings(
//    scalaVersion := "2.11.11",
//    libraryDependencies ++= Seq(
//      "io.github.widok" %%% "widok" % "0.2.3" withSources() withJavadoc(),
//      "com.lihaoyi" %%% "upickle" % "0.2.8",
//      "com.lihaoyi" %%% "autowire" % "0.2.5",
//      "org.webjars" % "bootstrap-sass" % "3.3.1",
//      "org.webjars" % "font-awesome" % "4.3.0-1"
//    ),
//    scalaJSUseMainModuleInitializer := true,
//    skip in packageJSDependencies := false,
//    artifactPath in(Compile, packageJSDependencies) := jsPath / "deps.js",
//    artifactPath in(Compile, optLevel) := jsPath / "application.js",
//    mainClass := Some("io.widok.client.Application")
//  )