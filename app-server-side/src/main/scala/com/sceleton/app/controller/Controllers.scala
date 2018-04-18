package com.sceleton.app.controller

import com.sceleton.app.api.Api
import com.sceleton.app.api.ExampleApi

class Controllers extends Api {
  override val example: ExampleApi = new ExampleController
}
