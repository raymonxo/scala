package raymitchell.euler.util

import org.scalatest.{FlatSpec, Matchers}

class MathFuncTests extends FlatSpec with Matchers {

  "Fibonaccis" should "start with the first 7 Fibonacci numbers" in {
    MathEx.fibonaccis.take(7) should be (Seq(0, 1, 1, 2, 3, 5, 8))
  }

  "Primes" should "start with the first 7 prime numbers" in {
    MathEx.primes.take(7) should be (Seq(2, 3, 5, 7, 11, 13, 17))
  }

  "Prime factors" should "return only the number for prime number" in {
    MathEx.primeFactors(17).toSet should be (Set(17))
  }

  "Prime factors" should "return the prime factors for non-prime number" in {
    MathEx.primeFactors(18).toSet should be (Set(2, 3, 3))
  }

  "Greatest commond divisor" should "provide correct answer" in {
    MathEx.gcd(8, 12) should be (4)
  }

  "Least commond multiple" should "provide correct answer" in {
    MathEx.lcm(8, 12) should be (24)
  }
}
