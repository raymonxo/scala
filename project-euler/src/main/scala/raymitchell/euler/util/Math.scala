package raymitchell.euler.util

import scala.annotation.tailrec

object Math {
  /**
    * All Fibonacci numbers.
    *
    * Determine the next Fibonacci number by adding previous two numbers.
    */
  val fibonacciSequence: Stream[Int] = 0 #:: 1 #::
    fibonacciSequence
      .zip(fibonacciSequence.tail)  // Zip n-1 and n-2 together
      .map(n => n._1 + n._2)        // n-1 + n-2

  /**
    * All prime numbers.
    *
    * Determine the next prime by iterating through natural numbers and finding
    * the next number that has no previous prime as a factor.
    */
  val primeSequence: Stream[Int] = 2 #::
    Stream
      .from(3)
      .filter(n => primeSequence    // Possible factors = previous primes
        .takeWhile(p => p * p <= n) // Max possible factor is sqrt(n)
        .forall(n % _ != 0))        // To be prime must have no factors

  /**
    * Get the prime factors of a number.
    *
    * A prime number is a factor of itself.  If a prime factor appears more
    * than once it will be repeated in the returned list.
    *
    * Examples:  primeFactors(8)  => List(2, 2, 2)
    *            primeFactors(17) => List(17)
    */
  def primeFactors(n: Long): Seq[Long] = {

    @tailrec
    def go(a: Long, primes: Seq[Int], factors: List[Long]): List[Long] = {
      val p = primes.head

      if (a == 1)            factors                         // All found
      else if (p * p > n)
        if (factors.isEmpty) List(n)                         // n is prime
        else                 factors                         // No more factors
      else if (a % p == 0)   go(a / p, primes, p :: factors) // Add factor
      else                   go(a, primes.tail, factors)     // Next candidate
    }

    go(n, primeSequence, Nil)
  }

  /**
    * Get greatest common divisor.
    *
    * Implemented using Euclid's algorithm.
    */
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  /**
    * Get least common multiple.
    *
    * Implemented using reduction by the greatest common divisor.
    */
  def lcm(a: Int, b: Int): Int = a * (b / gcd(a, b))
}
