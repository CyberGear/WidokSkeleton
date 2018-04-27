package com.sceleton.app

import com.sceleton.app.page.AboutPage
import com.sceleton.app.page.DatePage
import com.sceleton.app.page.HomePage
import com.sceleton.app.page.NotFoundPage
import org.widok.Page
import org.widok.Route

object Router {
  var routes: Set[Route] = Set.empty

  val index: Route = add("/", HomePage)
  val date: Route = add("/date", DatePage)
  val about: Route = add("/about", AboutPage)
  val `404`: Route = add("/404", NotFoundPage)

  private def add(path: String, page: () => Page): Route = {
    val route = Route(path, page)
    routes = (routes.toSeq :+ route).toSet
    route
  }

}
