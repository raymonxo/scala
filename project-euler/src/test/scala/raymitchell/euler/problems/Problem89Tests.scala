package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem89Tests extends FlatSpec with Matchers {

  "Problem 89" should "be solved correctly" in {
    Problem89.solve should be (743)
  }
}
