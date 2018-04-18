package com.sceleton.app.controller

import java.util.Date

import com.sceleton.app.api.ExampleApi

class ExampleController extends ExampleApi {
  override def date(): String = new Date().toString
}
