package raymitchell.euler.util

import scala.annotation.tailrec

object MathFunc {
  /**
    * Greatest common divisor.
    *
    * Implemented using Euclid's algorithm.
    */
  @tailrec
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  /**
    * Least common multiple.
    *
    * Implemented using reduction by the greatest common divisor.
    */
  def lcm(a: Long, b: Long): Long = a * b / gcd(a, b)
}
