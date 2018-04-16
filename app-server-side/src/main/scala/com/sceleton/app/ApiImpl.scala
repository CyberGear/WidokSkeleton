package com.sceleton.app

import com.sceleton.app.api.ExampleApi
import com.sceleton.app.api.ExampleApiImpl

class ApiImpl extends Api {
  val example: ExampleApi = new ExampleApiImpl
}
