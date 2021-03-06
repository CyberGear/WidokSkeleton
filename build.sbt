import src.main.scala.utils.NiceCrossType
import src.main.scala.utils.TaskUtil.SettingKeyUtil

disablePlugins(RevolverPlugin)
disablePlugins(AssemblyPlugin)

val optLevel = if (Configuration.release) fullOptJS else fastOptJS

val app = (crossProject.crossType(NiceCrossType) in file("."))
  .settings(Configuration.commonSettings: _*)
  .settings(
    libraryDependencies ++= Configuration.sharedDependencies.value
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer := true,
    skip in packageJSDependencies := false,
    artifactPath in(Compile, packageJSDependencies) mapValue (_.getParentFile / Configuration.dependenciesJs),
    artifactPath in (Compile, optLevel) mapValue (_.getParentFile / Configuration.applicationJs),
    libraryDependencies ++= Configuration.clientDependencies.value,
    jsDependencies ++= Configuration.jsDependencies.value,
  )
  .jvmSettings(
    libraryDependencies ++= Configuration.serverDependencies.value
  )

lazy val aClient = app.js.withId("app-client-side")
  .disablePlugins(RevolverPlugin)
  .disablePlugins(AssemblyPlugin)

lazy val aServer = app.jvm.withId("app-server-side")
  .settings(
    (resources in Compile) += (optLevel in(aClient, Compile)).value.data,
    (resources in Compile) += (packageJSDependencies in(aClient, Compile)).value,
    assemblyJarName := s"${name.value}-${version.value}.jar"
  )