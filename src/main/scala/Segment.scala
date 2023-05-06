package dev.mcabsan.paths

import scala.math.{pow, sqrt}

case class Segment(origin: Point, destination: Point) {
  def distance: Double = sqrt(pow(destination.x - origin.x, 2) + pow(destination.y - origin.y, 2))
}
