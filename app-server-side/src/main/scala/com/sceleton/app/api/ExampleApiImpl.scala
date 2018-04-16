package com.sceleton.app.api

import scala.util.Random

class ExampleApiImpl extends ExampleApi {

  val random: Random = Random

  def items: List[String] = (for (_ <- 1 to 10) yield random.nextString(16)).toList
}
