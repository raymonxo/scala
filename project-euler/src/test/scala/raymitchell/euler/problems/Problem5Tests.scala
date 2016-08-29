package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem5Tests extends FlatSpec with Matchers {

  "Problem 5" should "be solved correctly" in {
    Problem5.solve() should be (232792560)
  }
}
