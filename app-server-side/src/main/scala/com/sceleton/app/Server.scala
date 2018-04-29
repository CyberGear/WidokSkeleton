package com.sceleton.app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.ContentTypes.`text/html(UTF-8)`
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import autowire.Core.Request
import com.sceleton.BuildInfo
import com.sceleton.app.api.Api
import com.sceleton.app.controller.Controllers
import upickle.default

import scala.concurrent.ExecutionContext.Implicits.global
import io.github.shogowada.statictags.StaticTags._

object Server extends App {

  implicit val system: ActorSystem = ActorSystem.create()
  implicit val materializer: ActorMaterializer = ActorMaterializer.create(system)
  val controllers = new Controllers()
  val router = Router.route[Api](controllers)

  val indexHtml: String =
    <.html()(
      <.head()(
        <.title()("App"),
        <.script(^.defer := true, ^.src := "dependencies.js")(),
        <.script(^.defer := true, ^.src := "application.js")(),
        <.style()(
          """
            |body {
            |  padding: 0px;
            |  margin: 0px;
            |}
            |
            |.body {
            |  padding: 10px;
            |}
            |
            |.menu {
            |  background-color: #ccc;
            |  position: relative;
            |  padding: 10px;
            |}
            |
            |.menu-item {
            |  background-color: #ccc;
            |  padding: 10px;
            |}
            |
            |.menu-item:hover {
            |  background-color: #ccf;
            |}
            |
            |.menu-item:hover {
            |  background-color: #ccf;
            |}
            |
            |.menu-item.selected {
            |  background-color: #fcf;
            |}
            |
          """.stripMargin
        )
      ),
      <.body(^.id := "page")()
    ).toString()

  private val index = get {
    (pathSingleSlash & redirectToTrailingSlashIfMissing(StatusCodes.TemporaryRedirect)) {
      complete {
        HttpEntity(`text/html(UTF-8)`, indexHtml)
      }
    } ~ getFromResourceDirectory("")
  }

  private val api = post {
    path(Api.path / Segments) { segment =>
      entity(as[String]) { entity =>
        complete {
          router(Request(segment, default.read[Map[String, String]](entity)))
        }
      }
    }
  }

  Http().bindAndHandle(index ~ api, "0.0.0.0", port = BuildInfo.port)
  println(s"Started: http://localhost:${BuildInfo.port}")

}
