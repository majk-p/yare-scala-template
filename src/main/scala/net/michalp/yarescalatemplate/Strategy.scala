package net.michalp.yarescalatemplate
import scala.scalajs.js

import YareApi._
import YareModel._

@js.annotation.JSExportTopLevel("StrategyExecutor", "strategy.js")
object StrategyExecutor {
  Strategy.run()
}

object Strategy {

  def run(): Unit = {
    my_spirits.zipWithIndex.foreach { case (spirit, i) =>
      val target_star = selectStar(i)
      val target_base = nearestBase(target_star)

      if (spirit.energy == spirit.energy_capacity)
        spirit.set_mark("charging")
      else if (spirit.energy == 0)
        spirit.set_mark("harvesting")

      if (spirit.mark == "charging") {
        spirit.move(target_base.position)
        spirit.energize(target_base)
      } else if (spirit.mark == "harvesting") {
        spirit.move(target_star.position)
        spirit.energize(spirit);
      }
    }
  }

  private def nearestBase(star: Star): Base =
    star.id match {
      case "star_nua" => base_nua
      case "star_p89" => base_p89
      case "star_zxq" => base_zxq
      case "star_a2c" => base_a2c
      case _          => base_nua // dummy fallback
    }

  private def selectStar(spiritIndex: Double): Star =
    if (spiritIndex % 5 < 3) star_nua
    else if (spiritIndex % 5 == 3) star_p89
    else star_zxq

  private def distanceSquare(a: Coordinates, b: Coordinates) = {
    val deltaX = b._1 - a._1
    val deltaY = b._2 - a._2
    deltaX * deltaX + deltaY * deltaY
  }
}
