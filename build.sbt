import src.main.scala.utils.NiceCrossType
import src.main.scala.utils.TaskUtil.SettingKeyUtil

val port: Int = if (Configuration.release) 80 else 8080
val optLevel = if (Configuration.release) fullOptJS else fastOptJS

val app = (crossProject.crossType(NiceCrossType) in file("."))
  .settings(Configuration.commonSettings: _*)
  .settings(
    libraryDependencies ++= Configuration.sharedDependencies.value
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer := true,
    skip in packageJSDependencies := false,
    artifactPath in(Compile, packageJSDependencies) mapValue (_.getParentFile / Configuration.jsDependencies),
    artifactPath in (Compile, optLevel) mapValue (_.getParentFile / Configuration.jsApplication),
    libraryDependencies ++= Configuration.clientDependencies.value
  )
  .jvmSettings(
    libraryDependencies ++= Configuration.serverDependencies.value
  )

lazy val aClient = app.js.withId("app-client-side")
lazy val aServer = app.jvm.withId("app-server-side")
  .settings(
    (resources in Compile) += (optLevel in(aClient, Compile)).value.data,
    (resources in Compile) += (packageJSDependencies in(aClient, Compile)).value
  )