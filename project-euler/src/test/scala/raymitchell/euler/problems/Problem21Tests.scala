package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem21Tests extends FlatSpec with Matchers {

  "Problem 21" should "be solved correctly" in {
    Problem21.solve() should be (31626)
  }
}
