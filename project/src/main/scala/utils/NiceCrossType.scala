package src.main.scala.utils

import java.io.File

import org.scalajs.sbtplugin.cross.CrossType
import sbt._

object NiceCrossType extends CrossType {

  val names: (String) => String = {
    case "js"  => "app-client-side"
    case "jvm" => "app-server-side"
    case _     => "app-shared-code"
  }

  def projectDir(crossBase: File, projectType: String): File = crossBase / names(projectType)

  def sharedSrcDir(projectBase: File, conf: String): Option[File] =
    Some(projectBase.getParentFile / names("") / "src" / conf / "scala")

}