package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem15Tests extends FlatSpec with Matchers {

  "Problem 15" should "be solved correctly" in {
    Problem15.solve should be (137846528820L)
  }
}
