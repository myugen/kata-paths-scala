package dev.mcabsan.paths

object Paths {
  extension (paths: List[Path]) {
    def shortest: Option[Path] = if (paths.nonEmpty) Some(paths.minBy(_.distance)) else None
    def includeStopAt(point: Point): List[Path] = paths.filter(_.stops.contains(point))
    def includeStopsIn(points: List[Point]): List[Path] =
      paths.filter(path => points.forall(path.stops.contains(_)))
    def best(points: List[Point]): Option[Path] = includeStopsIn(points).shortest
  }
}
