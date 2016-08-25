package raymitchell.euler.util

import org.scalatest.{FlatSpec, Matchers}

class PrimeNumbersTests extends FlatSpec with Matchers {

  "Prime Numbers" should "start with the first 7 prime numbers" in {
    PrimeNumbers.take(7).toSeq should be (Seq(2, 3, 5, 7, 11, 13, 17))
  }
}
