package com.sceleton.app.page

import org.widok.InstantiatedRoute
import org.widok.View
import org.widok.html._

case class AboutPage() extends MainFramePage {
  override def body(route: InstantiatedRoute): View = div(
    p("This is so minimal widok page sceleton ;)")
  )
}
