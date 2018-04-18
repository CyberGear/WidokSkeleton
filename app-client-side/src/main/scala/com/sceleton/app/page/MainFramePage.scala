package com.sceleton.app.page

import com.sceleton.app.Router
import com.sceleton.app.widget.Menu
import org.widok.InstantiatedRoute
import org.widok.Page
import org.widok.Route
import org.widok.View
import org.widok.bindings.HTML.Container._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

trait MainFramePage extends Page {
  val route: Route

  def mainFrame(body: View): View = Generic(
    Menu(route, "Home" -> Router.index, "Date" -> Router.date, "About" -> Router.about),
    Generic(
      body
    ).css("body")
  )

  def body(route: InstantiatedRoute): View

  def render(route: InstantiatedRoute): Future[View] = Future[View](mainFrame(body(route)))
}
