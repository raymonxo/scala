package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem71Tests extends FlatSpec with Matchers {

  "Problem 71" should "be solved correctly" in {
    Problem71.solve should be (428570)
  }
}
