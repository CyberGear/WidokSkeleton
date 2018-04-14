import scala.sys.process.stringToProcess

object Git {

  lazy val commitCount: String = "git rev-list HEAD --count".!!.replace("\n", "")
  lazy val commitHash: String = "git log --pretty=format:'%h' -n 1".!!.replace("'", "").replace("\n", "")

}
