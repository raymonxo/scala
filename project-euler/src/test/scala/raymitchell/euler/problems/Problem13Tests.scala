package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem13Tests extends FlatSpec with Matchers {

  "Problem 13" should "be solved correctly" in {
    Problem13.solve should be ("5537376230")
  }
}
