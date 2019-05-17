package org.daron

import org.scalatest.{FlatSpec, Matchers}

class HelloWorldSpec extends FlatSpec with Matchers {

  it should "Run!" in {
    val result = true && false
    result shouldBe false
  }

}
