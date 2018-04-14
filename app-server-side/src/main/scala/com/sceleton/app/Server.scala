package com.sceleton.app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.ContentTypes.`text/html(UTF-8)`
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Server extends App {

  implicit val system: ActorSystem = ActorSystem.create()
  implicit val materializer: ActorMaterializer = ActorMaterializer.create(system)

  val routes = Seq(
    get {
      pathSingleSlash {
        complete {
          HttpEntity(`text/html(UTF-8)`,":)")
        }
      }
    }
  )

  Http().bindAndHandle(routes.reduce(_ ~ _), "0.0.0.0", port = 8080)
  println(s"Started: http://localhost:8080")

}
