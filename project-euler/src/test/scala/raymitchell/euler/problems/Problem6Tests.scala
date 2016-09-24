package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem6Tests extends FlatSpec with Matchers {

  "Problem 6" should "be solved correctly" in {
    Problem6.solve should be (25164150)
  }
}
