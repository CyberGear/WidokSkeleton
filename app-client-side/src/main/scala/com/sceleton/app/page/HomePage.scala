package com.sceleton.app.page
import com.sceleton.app.Router
import org.widok.InstantiatedRoute
import org.widok.Route
import org.widok.View
import org.widok.html._

case class HomePage() extends MainFramePage {

  override val route: Route = Router.index

  override def body(route: InstantiatedRoute): View = h3("Hey guys, I am very ugly skeleton ;)")

}
