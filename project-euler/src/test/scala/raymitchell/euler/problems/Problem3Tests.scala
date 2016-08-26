package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem3Tests extends FlatSpec with Matchers {

  "Problem 3" should "be solved correctly" in {
    Problem3.solve() should be (6857)
  }
}
