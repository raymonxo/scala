package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem9Tests extends FlatSpec with Matchers {

  "Problem 9" should "be solved correctly" in {
    Problem9.solve should be (31875000)
  }
}
