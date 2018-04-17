package com.sceleton.app.page
import autowire.clientCallable
import com.sceleton.app.Rest
import com.sceleton.app.Router
import com.sceleton.app.api.Api
import org.widok.InstantiatedRoute
import org.widok.Route
import org.widok.View
import org.widok.html._
import pl.metastack.metarx.Var

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success

case class DatePage() extends MainFramePage {

  override val route: Route = Router.date

  val date = Var("")

  Rest[Api].example.date().call().onComplete {
    case Success(d) => date := d
    case Failure(err) => println(err)
  }

  override def body(route: InstantiatedRoute): View = div(date)
}
