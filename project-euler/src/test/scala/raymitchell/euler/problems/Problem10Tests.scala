package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem10Tests extends FlatSpec with Matchers {

  "Problem 10" should "be solved correctly" in {
    Problem10.solve() should be (142913828922L)
  }
}
