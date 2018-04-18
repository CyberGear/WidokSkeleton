package com.sceleton.app.widget

import org.scalajs.dom.html.Element
import org.widok.Route
import org.widok.Widget
import org.widok.html._

case class Menu(selected: Route, routes: (String, Route)*) extends Widget[Menu] {
  override val rendered: Element = div(
    routes.map(menu => a(menu._1)
      .url(s"#${menu._2.path}")
      .css("menu-item")
      .cssState(menu._2 == selected, "selected")
    ): _*
  ).rendered

  css("menu")
}
