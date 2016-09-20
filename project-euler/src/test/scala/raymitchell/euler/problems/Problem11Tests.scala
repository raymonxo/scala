package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem11Tests extends FlatSpec with Matchers {

  "Problem 11" should "be solved correctly" in {
    Problem11.solve() should be (70600674)
  }
}
