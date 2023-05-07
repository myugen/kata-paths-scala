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
}
