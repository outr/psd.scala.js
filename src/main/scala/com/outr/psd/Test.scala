package com.outr.psd

import org.scalajs.dom._

import scala.scalajs._
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSON

object Test extends js.JSApp {
  @JSExportTopLevel("application")
  def main(): Unit = {
    println("Hello World!")
    val dropZone = document.getElementById("dropzone")
    dropZone.addEventListener("dragover", (evt: DragEvent) => {
      evt.stopPropagation()
      evt.preventDefault()
      evt.dataTransfer.dropEffect = "copy"
    }, useCapture = true)
    dropZone.addEventListener("drop", (evt: DragEvent) => {
      evt.stopPropagation()
      evt.preventDefault()
      PSD.fromEvent(evt).toFuture.foreach { psd =>
        val tree = psd.tree()
        val data = JSON.stringify(tree.export())
        println(s"PSD: $data")
        val image = document.getElementById("image");
        image.appendChild(psd.image.toPng())
      }
    }, useCapture = true)
  }
}
