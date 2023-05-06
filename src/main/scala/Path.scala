package dev.mcabsan.paths

case class Path(segments: List[Segment], stops: List[Segment]) {
  def distance: Double = throw NotImplementedError("TODO: implement distance")
}

extension (paths: List[Path]) {
  def shortestPath: Path = throw NotImplementedError("TODO: implement shortestPath")
}
