package dev.mcabsan.paths

import Paths._

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PathsSpec extends AnyFlatSpec with Matchers {

  behavior of "Paths"

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

  it should "retrieve all paths that include the given stop" in {
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

    paths.includeStopAt(Point(1, 1)) should be(List(path1, path3))
  }

  it should "retrieve all paths that include stops in given points" in {
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

    paths.includeStopsIn(List(Point(0, 0), Point(3, 4))) should be(List(path2))
  }

  it should "calculate the best path that include stops in given points" in {
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

    paths.best(List(Point(0, 0), Point(1, 1))) should be(Some(path1))
  }
}
