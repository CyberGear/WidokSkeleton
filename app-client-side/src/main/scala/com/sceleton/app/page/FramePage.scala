package com.sceleton.app.page

import org.widok.InstantiatedRoute
import org.widok.Page
import org.widok.View

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait FramePage extends Page {
  def mainFrame(body: View): View

  def body(route: InstantiatedRoute): View

  def render(route: InstantiatedRoute): Future[View] = Future[View](mainFrame(body(route)))
}