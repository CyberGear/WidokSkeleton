package com.sceleton.app.controller

import com.sceleton.app.api.ExampleApi

class ExampleController extends ExampleApi {
  override def items(): List[String] = List("Vilnius", "Kaunas", "Panevėžys")
}
