package com.sceleton.app.page

import com.sceleton.app.Router
import org.widok.InstantiatedRoute
import org.widok.Route
import org.widok.View
import org.widok.html

case class NotFoundPage() extends MainFramePage {

  override val route: Route = Router.`404`

  override def body(route: InstantiatedRoute): View = html.h1("404")
}
