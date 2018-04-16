package com.sceleton.app

import com.sceleton.app.api.ExampleApi

trait Api {

  val example: ExampleApi

}

object Api {

  val path: String = "api"

}
