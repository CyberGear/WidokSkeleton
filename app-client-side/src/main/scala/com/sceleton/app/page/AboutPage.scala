package com.sceleton.app.page

import com.sceleton.app.Router
import org.widok.InstantiatedRoute
import org.widok.Route
import org.widok.View
import org.widok.html._

case class AboutPage() extends MainFramePage {

  override val route: Route = Router.about

  override def body(route: InstantiatedRoute): View = div(
    p("This is so minimal widok page sceleton ;)")
  )
}
