package dev.mcabsan.paths

case class Path(segments: List[Segment]) {
  def distance: Double = segments.map(_.distance).sum
  def stops: List[Point] =
    segments.flatMap(segment => List(segment.origin, segment.destination)).distinct
}

extension (paths: List[Path]) {
  def shortest: Option[Path] = if (paths.nonEmpty) Some(paths.minBy(_.distance)) else None
  def includeStopAt(point: Point): List[Path] = paths.filter(_.stops.contains(point))
  def includeStopsIn(points: List[Point]): List[Path] =
    paths.filter(path => points.forall(path.stops.contains(_)))
  def best(points: List[Point]): Option[Path] = includeStopsIn(points).shortest
}
