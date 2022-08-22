package net.michalp.yarescalatemplate

import scala.scalajs.js
import scala.collection.mutable.Buffer

/** Yare API is defined as a set of top level variables, thus the JSGlobalScope
  * facade
  */
@js.native
@js.annotation.JSGlobalScope
object YareApi extends js.Object {

  import YareModel._

  val memory: js.Object = js.native

  val base_zxq: Base = js.native
  val base_a2c: Base = js.native
  val base_p89: Base = js.native
  val base_nua: Base = js.native

  val star_zxq: Star = js.native
  val star_a2c: Star = js.native
  val star_p89: Star = js.native
  val star_nua: Star = js.native

  val spirits: js.Map[String, Spirit] = js.native
  val my_spirits: js.Array[Spirit] = js.native

  val tick: Double = js.native
}
