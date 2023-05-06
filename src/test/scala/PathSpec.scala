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

  it should "calculate all stops" in {
    val path =
      Path(segments = List(Segment(Point(0, 0), Point(3, 4)), Segment(Point(3, 4), Point(3, 3))))

    path.stops should be(List(Point(0, 0), Point(3, 4), Point(3, 3)))
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

    paths.shortest should be(Some(path1))
  }

  it should "return all paths that include the given stop" in {
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

    paths.includeStop(Point(1, 1)) should be(List(path1, path3))
  }
}
