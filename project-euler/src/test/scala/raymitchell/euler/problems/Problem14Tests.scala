package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem14Tests extends FlatSpec with Matchers {

  "Problem 14" should "be solved correctly" in {
    Problem14.solve should be (837799)
  }
}
