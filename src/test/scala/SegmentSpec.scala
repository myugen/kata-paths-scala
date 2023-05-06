package dev.mcabsan.paths

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SegmentSpec extends AnyFlatSpec with Matchers {

  behavior of "A segment"

  it should "calculate the distance between origin and destination" in {
    val segment = Segment(Point(0, 0), Point(3, 4))
    segment.distance should be(5)
  }
}
