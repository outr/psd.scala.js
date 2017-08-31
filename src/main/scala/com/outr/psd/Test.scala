package com.outr.psd

import org.scalajs.dom._

import scala.scalajs._
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSON

object Test extends js.JSApp {
  @JSExportTopLevel("application")
  def main(): Unit = {
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
        try {
          println("Processing...")
          val tree = psd.tree()
          val image = document.getElementById("image")
          image.appendChild(psd.image.toPng())

          val data = document.getElementById("data")
          data.innerHTML = JSON.stringify(tree.export(), space = 2)

          val images = document.getElementById("images")
          tree.descendants().toList.foreach { node =>
            if (node.isGroup()) {
              val div = document.createElement("div").asInstanceOf[html.Div]
              div.innerHTML += s"<h3>${node.name} (group)</h3>"
              images.appendChild(div)
            } else {
              val div = document.createElement("div").asInstanceOf[html.Div]
              div.innerHTML += s"<h3>${node.name}</h3>"
              val export = node.export()
              export.text.foreach { text =>
                div.innerHTML += s"<h4><b>Text:</b> ${text.value} (${text.font.name}, ${text.font.sizes}, ${text.font.colors}, ${text.font.alignment})</h4>"
              }
              div.appendChild(node.toPng())
              images.appendChild(div)
            }
          }
        } catch {
          case t: Throwable => t.printStackTrace()
        }
      }
    }, useCapture = true)
  }

  def describe(obj: js.Object): Unit = {

  }
}
