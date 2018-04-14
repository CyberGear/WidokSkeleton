import TaskUtil.SettingKeyUtil

val port: Int = if (Configuration.release) 80 else 8080
val optLevel = if (Configuration.release) fullOptJS else fastOptJS

val app = (crossProject.crossType(NiceCrossType) in file("."))
  .settings(Configuration.commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq()
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer := true,
    skip in packageJSDependencies := false,
    artifactPath in(Compile, packageJSDependencies) mapValue (_.getParentFile / Configuration.dependenciesJsName),
    artifactPath in (Compile, optLevel) mapValue (_.getParentFile / Configuration.applicationJsName),
    libraryDependencies ++= Seq()
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.1.0",
      "com.typesafe.akka" %% "akka-actor" % "2.5.11",
      "com.typesafe.akka" %% "akka-stream" % "2.5.11")
  )

lazy val aClient = app.js.withId("app-client-side")
lazy val aServer = app.jvm.withId("app-server-side")
  .settings(
    (resources in Compile) += (optLevel in(aClient, Compile)).value.data,
    (resources in Compile) += (packageJSDependencies in(aClient, Compile)).value
  )

//lazy val server = crossProject.jvm
//  .settings(
//    scalaVersion := "2.11.11",
//    libraryDependencies ++= Seq(
//      "io.spray" %% "spray-can" % "1.3.1",
//      "io.spray" %% "spray-routing" % "1.3.1",
//      "com.typesafe.akka" %% "akka-actor" % "2.3.2",
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