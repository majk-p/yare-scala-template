package net.michalp.yarescalatemplate

import scala.scalajs.js
import scala.collection.mutable.Seq

object YareModel {

  @js.native
  trait Base extends js.Object {
    val id: String = js.native
    val structure_type: String = js.native
    val position: Coordinates = js.native
    val energy: Double = js.native
    val energy_capacity: Double = js.native
    val current_spirit_cost: Double = js.native
    val control: String = js.native
    val sight: Sight = js.native
  }

  object Base {
    def toString(base: Base): String =
      s"Base(id = ${base.id}, position = ${base.position}, energy = ${base.energy}, energy_capacity = ${base.energy_capacity}, control = ${base.control})"
  }
  @js.native
  trait Star extends js.Object {
    val id: String = js.native
    val structure_type: String = js.native
    val position: Coordinates = js.native
    val energy: Double = js.native
    val energy_capacity: Double = js.native
    val regeneration: Double = js.native
  }

  @js.native
  trait Sight extends js.Object {
    val friends: js.Array[String] = js.native
    val enemies: js.Array[String] = js.native
    val structures: js.Array[String] = js.native
  }

  @js.native
  trait Spirit extends js.Object {

    val id: String = js.native // in form of username_number
    val position: Coordinates = js.native
    val size: Double = js.native
    val energy_capacity: Double = js.native
    val energy: Double = js.native
    val hp: Double = js.native // 0 if dead = js.native 1 if alive
    val mark: String = js.native // custom mark set with set_mark() method
    val last_energized: String = js.native // id of last energized object
    val shape: String = js.native // one of 'circles' 'squares' or 'triangles'
    val player_id: String = js.native
    val sight: Sight = js.native

    def energize(target: Base): Unit = js.native
    def energize(target: Spirit): Unit = js.native
    def energize(target: Star): Unit = js.native
    def energize(target: Coordinates): Unit = js.native

    def move(target: Base): Unit = js.native
    def move(target: Spirit): Unit = js.native
    def move(target: Star): Unit = js.native
    def move(target: Coordinates): Unit = js.native

    def jump(target: Base): Unit = js.native
    def jump(target: Spirit): Unit = js.native
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

  type Coordinates = js.Tuple2[Double, Double]
}
