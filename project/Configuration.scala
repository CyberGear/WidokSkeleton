import sbt.Keys.name
import sbt.Keys.organization
import sbt.Keys.scalaVersion
import sbt.Keys.scalacOptions
import sbt.Keys.version

object Configuration {

  lazy val commonSettings = Seq(
    scalaVersion := "2.11.12",
    organization := "com.sceleton",
    name := "app",
    version := s"0.1.${Git.commitCount}",
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps"
    )
  )

  lazy val release: Boolean = sys.props.getOrElse("release", "false") == "true"
  lazy val dependenciesJsName = "deps.js"
  lazy val applicationJsName = "application.js"

}
