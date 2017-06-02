package com.outr.psd

import org.scalajs.dom.html
import org.scalajs.dom.raw.{Event, File}

import scala.scalajs._
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}

@js.native
@JSImport("psd", JSImport.Namespace)
object PSD extends js.Object {
  def fromURL(url: String): js.Thenable[PSD] = js.native
  def fromEvent(e: Event): js.Thenable[PSD] = js.native
  def fromDroppedFile(file: File): js.Thenable[PSD] = js.native
}

@ScalaJSDefined
trait PSD extends js.Object {
  def tree(): PSDTree = js.native
  def image: PSDImage = js.native
}

@ScalaJSDefined
trait PSDTree extends js.Any {
  def export(): js.Object = js.native
  def descendants(): js.Array[PSDLayer] = js.native
}

@ScalaJSDefined
trait PSDImage extends js.Any {
  def toPng(): html.Image = js.native
}

@ScalaJSDefined
trait PSDLayer extends js.Any {
  def export(): js.Object = js.native
  def toPng(): html.Image = js.native
}