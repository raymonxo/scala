package raymitchell.euler

import org.scalatest.{FlatSpec, Matchers}

class ProjectEulerTests extends FlatSpec with Matchers {
  it should "solve problem 1" in {
    Problem1.solve() should be (233168)
  }
}
