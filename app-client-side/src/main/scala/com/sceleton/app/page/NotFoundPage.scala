package com.sceleton.app.page

import org.widok.InstantiatedRoute
import org.widok.View
import org.widok.html

case class NotFoundPage() extends MainFramePage {
  override def body(route: InstantiatedRoute): View = html.h1("404")
}
