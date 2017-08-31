package com.outr.psd

import org.scalajs.dom._
import org.scalajs.dom.raw.{Event, File}

import scala.scalajs._
import scala.scalajs.js.annotation.ScalaJSDefined

object PSD {
  private lazy val psd = window.require[PSDImplementation]("psd")

  def fromURL(url: String): js.Thenable[PSD] = psd.fromURL(url)
  def fromEvent(e: Event): js.Thenable[PSD] = psd.fromEvent(e)
  def fromDroppedFile(file: File): js.Thenable[PSD] = psd.fromDroppedFile(file)
  def fromFile(file: File): js.Thenable[PSD] = fromDroppedFile(file)
}

@ScalaJSDefined
trait PSDImplementation extends js.Object {
  def fromURL(url: String): js.Thenable[PSD]
  def fromEvent(e: Event): js.Thenable[PSD]
  def fromDroppedFile(file: File): js.Thenable[PSD]
}

@ScalaJSDefined
trait PSD extends js.Object {
  def image: PSDImage

  def file: PSDFile
  def parsed: Boolean
  def header: PSDHeader
  def resources: js.Object
  def layerMask: js.Object

  def tree(): PSDTree
}

@ScalaJSDefined
trait PSDTree extends js.Any {
  def export(): js.Object
  def descendants(): js.Array[PSDNode]
  def children(): js.Array[PSDNode]
}

@ScalaJSDefined
trait PSDImage extends js.Any {
  def toPng(): html.Image
}

@ScalaJSDefined
trait PSDNode extends js.Object {
  def layer: PSDLayer
  def parent: js.Object
  def _children: js.Array[PSDNode]
  def name: String
  def forceVisible: Boolean
  def coords: js.Object
  def topOffset: js.Object
  def leftOffset: js.Object

  def children(): js.Array[PSDNode]
  def isGroup(): Boolean
  def export(): PSDNodeExport
  def toPng(): html.Image
}

@ScalaJSDefined
trait PSDLayer extends js.Object {
  def file: js.Object
  def header: js.Object
  def mask: js.UndefOr[PSDMask]
  def blendingRanges: js.Object
  def adjustments: js.Object
  def channelsInfo: js.Object
  def blendMode: js.Object
  def groupLayer: js.Object
  def infoKeys: js.Object
  def top: Double
  def left: Double
  def bottom: Double
  def right: Double
  def channels: js.Object
  def height: Double
  def rows: js.Object
  def width: Double
  def cols: js.Object
  def opacity: Double
  def visible: Boolean
  def clipped: js.Object
  def layerEnd: js.Object
  def legacyName: js.Object
  def solidColor: js.Object
  def vectorMask: js.Object
  def vectorOrigination: js.Object
  def typeTool: js.UndefOr[js.Function0[js.Object]]
  def layerNameSource: js.Object
  def layerId: js.Object
  def blendClippingElements: js.Object
  def blendInteriorElements: js.Object
  def locked: js.Object
  def metadata: js.Object
  def image: js.Object
  def node: PSDNode
}

@ScalaJSDefined
trait PSDNodeExport extends js.Any {
  def `type`: String
  def visible: Boolean
  def opacity: Double
  def blendingMode: String
  def name: String
  def left: Double
  def right: Double
  def top: Double
  def bottom: Double
  def height: Double
  def width: Double
  def mask: js.UndefOr[PSDMask]
  def text: js.UndefOr[PSDText]
  def image: js.UndefOr[js.Object]
}

@ScalaJSDefined
trait PSDHeader extends js.Any {
  def file: PSDFile
}

@ScalaJSDefined
trait PSDFile extends js.Any {
  def data: js.Object
}

@ScalaJSDefined
trait PSDMask extends js.Any {
  def top: Double
  def left: Double
  def bottom: Double
  def right: Double
  def width: Double
  def height: Double
  def defaultColor: Double
  def relative: Boolean
  def disabled: Boolean
  def invert: Boolean
}

@ScalaJSDefined
trait PSDText extends js.Any {
  def value: String
  def font: PSDFont
  def left: Double
  def top: Double
  def right: Double
  def bottom: Double
  def transform: PSDTransform
}

@ScalaJSDefined
trait PSDFont extends js.Any {
  def name: String
  def sizes: js.Array[Double]
  def colors: js.Array[js.Array[Double]]
  def alignment: js.Array[String]
}

@ScalaJSDefined
trait PSDTransform extends js.Any {
  def xx: Double
  def xy: Double
  def yx: Double
  def yy: Double
  def tx: Double
  def ty: Double
}