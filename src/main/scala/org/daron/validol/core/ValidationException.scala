package org.daron.validol.core

final case class ValidationException(message: String) extends Exception(message, null, false, true)
