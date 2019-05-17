package org.daron.validol.core

import cats.instances.list._
import cats.instances.parallel._
import cats.syntax.either._
import cats.{MonadError, Monoid, Parallel}

object Validator {

  implicit val stringMonoid = new Monoid[String] {
    override def empty: String = ""
    override def combine(x: String, y: String): String = x + "\n" + y
  }

  def validate[T](value: T, rules: Rule[T]*): Either[String, Unit] = {
    val es: List[Either[String, Unit]] = rules.map(r => r.v(value)).toList
    Parallel.parSequence(es).map(_ => ())
  }

  def validateM[F[_]: MonadError[?[_], Throwable], T](value: T, rules: Rule[T]*): F[Unit] = {
    MonadError[F, Throwable].fromEither(validate(value, rules: _*).leftMap(ValidationException))
  }

}
