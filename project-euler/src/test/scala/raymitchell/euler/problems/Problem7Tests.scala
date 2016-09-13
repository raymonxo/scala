package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem7Tests extends FlatSpec with Matchers {

  "Problem 7" should "be solved correctly" in {
    Problem7.solve() should be (104743)
  }
}
