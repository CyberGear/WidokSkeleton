package com.sceleton.app.widget

import org.scalajs.dom.html.Element
import org.widok.Route
import org.widok.Widget
import org.widok.html._
import pl.metastack.metarx.Var

case class Menu(selected: Var[Route], routes: (String, Route)*) extends Widget[Menu]{
  override val rendered: Element = div(
//    routes.map(menu => a(menu._1).url(menu._2.toString).css("menu-item").cssState(menu._2 == selected, "")): _*
  ).rendered
  css("menu")
}
