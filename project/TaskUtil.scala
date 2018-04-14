import sbt.Def
import sbt.SettingKey

object TaskUtil {

  implicit class SettingKeyUtil[A](setting: SettingKey[A]) {
    def mapValue(f: A => A): Def.Setting[A] = setting := f(setting.value)
  }

}
