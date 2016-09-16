package raymitchell.euler.problems

import org.scalatest.{FlatSpec, Matchers}

class Problem8Tests extends FlatSpec with Matchers {

  "Problem 8" should "be solved correctly" in {
    Problem8.solve() should be (23514624000L)
  }
}
