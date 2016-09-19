package raymitchell.euler.util

import org.scalatest.{FlatSpec, Matchers}

import raymitchell.euler.util.Math._

class MathTests extends FlatSpec with Matchers {

  "Fibonaccis" should "start with the first 7 Fibonacci numbers" in {
    fibonacciSequence.take(7) should be (Seq(0, 1, 1, 2, 3, 5, 8))
  }

  "Primes" should "start with the first 7 prime numbers" in {
    primeSequence.take(7) should be (Seq(2, 3, 5, 7, 11, 13, 17))
  }

  "Prime factors" should "return only the number for prime number" in {
    17.primeFactors.toSet should be (Set(17))
  }

  "Prime factors" should "return the prime factors for non-prime number" in {
    18.primeFactors.toSet should be (Set(2, 3, 3))
  }

  "Greatest common divisor" should "provide correct answer" in {
    8 gcd 12 should be (4)
  }

  "Least common multiple" should "provide correct answer" in {
    8 lcm 12 should be (24)
  }
}
