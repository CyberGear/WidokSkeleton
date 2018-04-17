package com.sceleton.app.page

import com.sceleton.app.Router
import com.sceleton.app.widget.Menu
import org.widok.Route
import org.widok.View
import org.widok.bindings.HTML.Container._
import pl.metastack.metarx.Var

trait MainFramePage extends FramePage {

  val selectedRoute: Var[Route] = Var(Router.index)

  override def mainFrame(body: View): View = Generic(
    Menu(selectedRoute, "Home" -> Router.index, "3 Cities" -> Router.index, "About" -> Router.about),
    Generic(
      body
    )
  )
}
