package com.outr.psd

import org.scalajs.dom.html
import org.scalajs.dom.raw.{Event, File}

import scala.scalajs._
import scala.scalajs.js.annotation.{JSGlobal, JSImport, ScalaJSDefined}

@js.native
//@JSImport("psd", JSImport.Namespace)
@JSGlobal("PSD")
object PSD extends js.Object {
  def fromURL(url: String): js.Thenable[PSD] = js.native
  def fromEvent(e: Event): js.Thenable[PSD] = js.native
  def fromDroppedFile(file: File): js.Thenable[PSD] = js.native
}

@ScalaJSDefined
trait PSD extends js.Object {
  def tree(): PSDTree
  def image: PSDImage
}

@ScalaJSDefined
trait PSDTree extends js.Any {
  def export(): js.Object
  def descendants(): js.Array[PSDLayer]
}

@ScalaJSDefined
trait PSDImage extends js.Any {
  def toPng(): html.Image
}

@ScalaJSDefined
trait PSDLayer extends js.Any {
  def export(): js.Object
  def toPng(): html.Image
}