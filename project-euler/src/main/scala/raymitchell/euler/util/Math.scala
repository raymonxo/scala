package raymitchell.euler.util

import scala.annotation.tailrec

object Math {
  import scala.language.implicitConversions

  implicit def long2FancyLong(x: Long): FancyLong = new FancyLong(x)

  /**
    * All Fibonacci numbers.
    *
    * Determine the next Fibonacci number by adding previous two numbers.
    */
  val FibonacciNumbers: Stream[Long] = 0 #:: 1 #::
    FibonacciNumbers
      .zip(FibonacciNumbers.tail) // Zip n-2 and n-1 together
      .map(n => n._1 + n._2)      // n-2 + n-1

  /**
    * All prime numbers.
    *
    * Determine the next prime by iterating through natural numbers and finding
    * the next number that has no previous prime as a factor.
    */
  val PrimeNumbers: Stream[Long] = 2L #::
    Stream
      .iterate(3L)(_ + 2)
      .filter(n => PrimeNumbers     // Possible factors = previous primes
        .takeWhile(p => p * p <= n) // Max possible factor is sqrt(n)
        .forall(n % _ != 0))        // To be prime must have no factors

  /**
    * All triangle numbers.
    *
    * The sequence of triangle numbers is generated by adding the natural
    * numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 +
    * 7 = 28.
    */
  val TriangleNumbers: Stream[Long] = 1 #::
    Stream
      .iterate(2L)(_ + 1)
      .zip(TriangleNumbers)  // Zip next nat # with previous triangle #
      .map(n => n._1 + n._2)
}

final class FancyLong(self: Long) {
  import raymitchell.euler.util.Math._

  /**
    * Get the prime factors of a number.
    *
    * A prime number is a factor of itself.  If a prime factor appears more
    * than once it will be repeated in the returned list.
    *
    * Examples:  8.primeFactors  => List(2, 2, 2)
    *            17.primeFactors => List(17)
    */
  def primeFactors: Seq[Long] = {

    @tailrec
    def go(a: Long, primes: Seq[Long], factors: List[Long]): List[Long] = {
      val p = primes.head

      if (a == 1)               factors                         // All found
      else if (p * p > self)
           if (factors.isEmpty) List(self)                      // self prime
           else                 factors                         // No more
      else if (a % p == 0)      go(a / p, primes, p :: factors) // Found
      else                      go(a, primes.tail, factors)     // Next
    }

    go(self, PrimeNumbers, Nil)
  }

  /**
    * Get the divisors of a number.  The divisors of a number n are the numbers
    * less than or equal to n which divide evenly into n.
    */
  def divisors: Seq[Long] =
    (for (
      x <- 1L to scala.math.sqrt(self).toLong
      if self % x == 0
    ) yield List(x, self / x))
      .flatten
      .distinct

  /**
    * Get the proper divisors of a number.  The proper divisors of a number n
    * are the numbers less than n which divide evenly into n.
    */
  def properDivisors: Seq[Long] = divisors.filter(_ != self)

  /**
    * Get greatest common divisor.
    *
    * Implemented using Euclid's algorithm.
    */
  @tailrec
  def gcd(other: Long): Long =
    if (other == 0) self
    else            other.gcd(self % other)

  /**
    * Get least common multiple.
    *
    * Implemented using reduction by the greatest common divisor.
    */
  def lcm(other: Long): Long = self * (other / (self gcd other))

  /**
    * Return all rotations of the number's digits.
    *
    * For example, the rotations of 197 are 197, 971, and 719.
    */
  def rotations: Seq[Long] = {
    val s = self.toString
    s.tails.toSeq.reverse.zip(s.inits.toSeq).map(p => (p._1 + p._2).toLong)
  }

  /**
    * Return whether the number is palindromic.  A palindromic number reads the
    * same both ways.
    */
  def isPalindromic: Boolean = self.toString == self.toString.reverse

  /**
    * Return whether the number is amicable.  A number n is amicable if the sum
    * of it's divisors equals m, the sum of m's divisors equals n, and n != m.
    *
    * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
    * 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
    * 2, 4, 71 and 142; so d(284) = 220.
    */
  def isAmicable: Boolean = {
    val m = self.properDivisors.sum
    m.properDivisors.sum == self && m != self
  }
}