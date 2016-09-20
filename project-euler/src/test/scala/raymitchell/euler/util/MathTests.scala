package raymitchell.euler.util

import org.scalatest.{FlatSpec, Matchers}

import raymitchell.euler.util.Math._

class MathTests extends FlatSpec with Matchers {

  "Fibonaccis" should "start with the first 7 Fibonacci numbers" in {
    FibonacciSequence.take(7) should be (Seq(0, 1, 1, 2, 3, 5, 8))
  }

  "Primes" should "start with the first 7 prime numbers" in {
    PrimeSequence.take(7) should be (Seq(2, 3, 5, 7, 11, 13, 17))
  }

  "Triangle numbers" should "start with the first 7 triangle numbers" in {
    TriangleNumberSequence.take(7) should be (Seq(1, 3, 6, 10, 15, 21, 28))
  }

  "Prime factors" should "return only the number for prime number" in {
    17.primeFactors.toSet should be (Set(17))
  }

  "Prime factors" should "return the prime factors for non-prime number" in {
    18.primeFactors.toSet should be (Set(2, 3, 3))
  }

  "Divisors" should "returns the divisors for a number" in {
    220.divisors.toSet should be (Set(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110, 220))
  }

  "Proper divisors" should "returns the proper divisors for a number" in {
    220.properDivisors.toSet should be (Set(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110))
  }

  "Greatest common divisor" should "provide correct answer" in {
    8 gcd 12 should be (4)
  }

  "Least common multiple" should "provide correct answer" in {
    8 lcm 12 should be (24)
  }
}
