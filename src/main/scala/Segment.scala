package dev.mcabsan.paths

case class Segment(origin: Point, destination: Point) {
  def distance: Double = throw NotImplementedError("TODO: Implement distance")
}
