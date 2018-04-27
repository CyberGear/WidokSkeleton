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
  lazy val dependenciesJs: String = "dependencies.js"
  lazy val applicationJs: String = "application.js"

  lazy val clientDependencies = Def.setting(Seq(
    "io.github.widok" %%% "widok" % "0.2.4" withSources() withJavadoc()
  ))

  lazy val jsDependencies = Def.setting(Seq(
  ))

  lazy val serverDependencies = Def.setting(Seq(
    "com.typesafe.akka" %% "akka-http" % "10.1.0",
    "com.typesafe.akka" %% "akka-actor" % "2.5.11",
    "com.typesafe.akka" %% "akka-stream" % "2.5.11"
  ))

  lazy val sharedDependencies = Def.setting(Seq(
    "com.lihaoyi" %%% "upickle" % "0.6.5",
    "com.lihaoyi" %%% "autowire" % "0.2.5",
    "io.github.shogowada" %%% "statictags" % "2.5.0"
  ))

}