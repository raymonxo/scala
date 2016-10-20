package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem35Tests extends FlatSpec with Matchers {

  "Problem 35" should "be solved correctly" in {
    Problem35.solve should be (55)
  }
}
