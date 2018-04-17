package com.sceleton.app

import com.sceleton.app.page.AboutPage
import com.sceleton.app.page.NotFoundPage
import org.widok.Route
import org.widok.RoutingApplication

object Router {
  var routes: Set[Route] = Set.empty

  val index: Route = add(Route("/", AboutPage))
  val about: Route = add(Route("/about", AboutPage))
  val `404`: Route = add(Route("/404", NotFoundPage))

  private def add(route: Route): Route = {
    routes = (routes.toSeq :+ route).toSet
    route
  }

}

object Application extends RoutingApplication(Router.routes, Router.`404`)
