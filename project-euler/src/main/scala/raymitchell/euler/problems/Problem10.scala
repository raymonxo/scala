package raymitchell.euler.problems

import raymitchell.euler.util.Math._

/**
  * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  *
  * Find the sum of all the primes below two million.
  */
object Problem10 {

  def solve: Long =
    PrimeNumbers
      .takeWhile(_ < 2000000)
      .sum
}
