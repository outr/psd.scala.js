package com.outr

import org.scalajs.dom._

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, ScalaJSDefined}

package object psd {
  implicit def window2RequiresWindow(window: Window): RequiresWindow = window.asInstanceOf[RequiresWindow]
}

@ScalaJSDefined
trait RequiresWindow extends js.Object {
  def require[T](name: String): T
}