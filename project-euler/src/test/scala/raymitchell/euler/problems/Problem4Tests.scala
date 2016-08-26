package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem4Tests extends FlatSpec with Matchers {

  "Problem 4" should "be solved correctly" in {
    Problem4.solve() should be (906609)
  }
}
