package org.daron.validol.core

import scala.reflect.ClassTag

final case class Rule[T](v: T => Either[String, Unit])

object Rule {

  def createRule[T: ClassTag](
    test: T => Boolean,
    failureMessage: String,
    prefixOpt: Option[String] = None
  ): Rule[T] = {
    val prefix = prefixOpt.getOrElse { implicitly[ClassTag[T]].runtimeClass.getSimpleName }
    Rule[T](entity => Either.cond[String, Unit](test(entity), (), s"$prefix: $failureMessage"))
  }


}
