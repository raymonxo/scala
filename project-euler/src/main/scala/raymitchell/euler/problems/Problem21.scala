package raymitchell.euler.problems

import raymitchell.euler.util.Math._

/**
  * Let d(n) be defined as the sum of proper divisors of n (numbers less than
  * n which divide evenly into n).
  *
  * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair
  * and each of a and b are called amicable numbers.
  *
  * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
  * 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
  * 2, 4, 71 and 142; so d(284) = 220.
  *
  * Evaluate the sum of all the amicable numbers under 10000.
  */
object Problem21 {

  def solve(): Int = {
    val divisorSums = for (x <- 1 until 10000) yield (x, x.properDivisors.sum)

    (for {
      a <- divisorSums
      b <- divisorSums
      if a._2 == b._1   // d(a) = b
      if b._2 == a._1   // d(b) = a
      if a._1 != b._1   // a != b
    } yield a._1)
      .sum
  }
}
