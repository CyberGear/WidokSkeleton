package com.sceleton.app

import ujson.Js.Value
import upickle.default

object Router extends autowire.Server[Value, default.Reader, default.Writer]{
  def read[Result: default.Reader](p: Value): Result = default.readJs[Result](p)
  def write[Result: default.Writer](r: Result): Value = default.writeJs(r)
}