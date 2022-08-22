package net.michalp.yarescalatemplate

import scala.scalajs.js
import scala.collection.mutable.Buffer

/** Yare API is defined as a set of top level variables, thus the JSGlobalScope
  * facade
  */
@js.native
@js.annotation.JSGlobalScope
object YareApi extends js.Object {

  import Model._

  val memory: js.Object = js.native

  val base_zxq: Base = js.native
  val base_a2c: Base = js.native
  val base_p89: Base = js.native
  val base_nua: Base = js.native

  val star_zxq: Star = js.native
  val star_a2c: Star = js.native
  val star_p89: Star = js.native
  val star_nua: Star = js.native

  val spirits: Buffer[Spirit] = js.native
  val my_spirits: Buffer[Spirit] = js.native

  val tick: Double = js.native
}

object Model {

  case class Base(
      id: String,
      structure_type: String,
      position: Coordinates,
      energy_capacity: Double,
      current_spirit_cost: Double,
      control: String,
      sight: Sight
  )

  class Star(
      id: String,
      structure_type: String,
      position: Coordinates,
      energy: Double,
      energy_capacity: Double,
      regeneration: Double
  )

  case class Sight(
      friends: Buffer[String],
      enemies: Buffer[String],
      structures: Buffer[String]
  )

  @js.annotation.JSGlobal
  @js.native
  class Spirit(
      id: String, // in form of username_number
      position: Coordinates,
      size: Double,
      energy_capacity: Double,
      energy: Double,
      hp: Double, // 0 if dead, 1 if alive
      mark: String, // custom mark set with set_mark() method
      last_energized: String, // id of last energized object
      shape: String, // one of 'circles' 'squares' or 'triangles'
      player_id: String,
      sight: Sight
  ) extends js.Object {
    def energize(target: Base): Unit = js.native
    def energize(target: Star): Unit = js.native
    def energize(target: Coordinates): Unit = js.native

    def move(target: Base): Unit = js.native
    def move(target: Star): Unit = js.native
    def move(target: Coordinates): Unit = js.native

    def jump(target: Base): Unit = js.native
    def jump(target: Star): Unit = js.native
    def jump(target: Coordinates): Unit = js.native

    def shout(message: String): Unit = js.native
    def set_mark(label: String): Unit = js.native

    // Shape specific apis below

    // Only works for circles but facade doesn't reflect that
    def merge(target: Spirit): Unit = js.native

    // Only works for circles but facade doesn't reflect that
    def divide(): Unit = js.native

    // Only works for squares but facade doesn't reflect that
    def lock(): Unit = js.native
    // Only works for squares but facade doesn't reflect that
    def unlock(): Unit = js.native

    // Only works for triangles but facade doesn't reflect that
    def explode(): Unit = js.native
  }

  type Coordinates = (Double, Double)
}
