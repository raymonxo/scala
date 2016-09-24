package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem1Tests extends FlatSpec with Matchers {

  "Problem 1" should "be solved correctly" in {
    Problem1.solve should be (233168)
  }
}
