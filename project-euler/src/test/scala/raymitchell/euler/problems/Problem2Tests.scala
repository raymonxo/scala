package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem2Tests extends FlatSpec with Matchers {

  "Problem 2" should "be solved correctly" in {
    Problem2.solve should be (4613732)
  }
}
