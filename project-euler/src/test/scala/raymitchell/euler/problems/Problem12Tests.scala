package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem12Tests extends FlatSpec with Matchers {

  "Problem 12" should "be solved correctly" in {
    Problem12.solve() should be (76576500)
  }
}
