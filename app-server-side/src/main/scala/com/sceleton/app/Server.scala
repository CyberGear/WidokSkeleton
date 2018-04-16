package com.sceleton.app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.ContentTypes.`text/html(UTF-8)`
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scalatags.Text.all._
import scalatags.Text.{all => tag}
import scalatags.Text.tags2
import upickle.default

object Server extends App {

  implicit val system: ActorSystem = ActorSystem.create()
  implicit val materializer: ActorMaterializer = ActorMaterializer.create(system)
  val apiImpl = new ApiImpl()
  val router = Router.route[Api](apiImpl)

  val indexHtml: String =
    html(
      tag.head(
        tags2.title("App"),
        script(attr("defer") := true, src := "dependencies.js"),
        script(attr("defer") := true, src := "application.js")),
      body()).render



  private val index = get {
    (pathSingleSlash & redirectToTrailingSlashIfMissing(StatusCodes.TemporaryRedirect)) {
      complete {
        HttpEntity(`text/html(UTF-8)`, indexHtml)
      }
    } ~ getFromResourceDirectory("")
  }

  private val api = post {
    path(Api.path / Segments) { segment =>
      entity(as[String]) { e =>
        complete {
          router(Request(segment, default.read[Map[String, String]](e)))
        }
      }
    }
  }

  Http().bindAndHandle(index ~ api, "0.0.0.0", port = 8080)
  println(s"Started: http://localhost:8080")

}
