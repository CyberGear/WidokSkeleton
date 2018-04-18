package com.sceleton.app

import com.sceleton.app.api.Api
import org.scalajs.dom
import upickle.default
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

object Rest extends autowire.Client[String, default.Reader, default.Writer]{
  override def doCall(req: Request): Future[String] = {
    dom.ext.Ajax.post(
      url = Api.path + req.path.mkString("/", "/", ""),
      data = default.write(req.args)
    ).map(_.responseText)
  }

  def read[Result: default.Reader](p: String): Result = default.read[Result](p)
  def write[Result: default.Writer](r: Result): String = default.write(r)
}