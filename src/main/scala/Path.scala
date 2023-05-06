package dev.mcabsan.paths

case class Path(segments: List[Segment], stops: List[Point] = List.empty) {
  def distance: Double = segments.map(_.distance).sum
}

extension (paths: List[Path]) {
  def shortestPath: Path = paths.minBy(_.distance)
}
