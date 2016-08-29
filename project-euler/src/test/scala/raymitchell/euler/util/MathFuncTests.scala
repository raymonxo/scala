package raymitchell.euler.util

import org.scalatest.{FlatSpec, Matchers}

class MathFuncTests extends FlatSpec with Matchers {

  "Greatest commond divisor" should "provide correct answer" in {
    MathFunc.gcd(8, 12) should be (4)
  }

  "Least commond multiple" should "provide correct answer" in {
    MathFunc.lcm(8, 12) should be (24)
  }
}
