package org.daron.core

import org.daron.validol.core.{Rule, Validator}
import org.scalatest.{EitherValues, FlatSpec, Matchers}

class ValidatorSpec extends FlatSpec with Matchers with EitherValues {


  it should "validate simple rules" in {
    val errorMessage = "String's length should be greater than 1"
    val rule = Rule.createRule[String](_.length > 1, errorMessage)

    val result1 = Validator.validate("1", rule)
    result1.left.value should endWith(errorMessage)

    val result2 = Validator.validate("very long string for sure", rule)
    result2 should be ('right)
  }

}
