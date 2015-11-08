package io.cenet.scalajs

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

@JSExport
object ScalaJs {
  
  @JSExport
  def total(i : Int) = ScalaService.factor(i)
  
}