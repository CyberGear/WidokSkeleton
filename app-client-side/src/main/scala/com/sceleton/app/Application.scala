package com.sceleton.app

import org.widok.RoutingApplication

object Application extends RoutingApplication(Router.routes, Router.`404`)
