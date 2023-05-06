package dev.mcabsan.paths

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PathSpec extends AnyFlatSpec with Matchers {

  behavior of "A path"

  it should "calculate distance of all segments" in {
    val path =
      Path(segments = List(Segment(Point(0, 0), Point(3, 4)), Segment(Point(3, 4), Point(3, 3))))

    path.distance should be(6)
  }

  behavior of "Multiple paths"

  it should "calculate the shortest path" in {
    val path1 =
      Path(segments = List(Segment(Point(0, 0), Point(0, 1)), Segment(Point(0, 1), Point(1, 1))))
    val path2 =
      Path(segments = List(Segment(Point(0, 0), Point(3, 4)), Segment(Point(3, 4), Point(3, 3))))
    val path3 = Path(segments =
      List(
        Segment(Point(0, 0), Point(1, 0)),
        Segment(Point(1, 0), Point(1, 1)),
        Segment(Point(1, 1), Point(0, 1))
      )
    )

    val paths = List(path1, path2, path3)

    paths.shortestPath should be(path1)
  }
}
