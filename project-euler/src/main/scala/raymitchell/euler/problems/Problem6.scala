package raymitchell.euler.problems

import raymitchell.euler.util.MathFunc

/**
  * The sum of the squares of the first ten natural numbers is,
  *
  * 1^2 + 2^2 + ... + 10^2 = 385
  *
  * The square of the sum of the first ten natural numbers is,i thin
  *
  * (1 + 2 + ... + 10)^2 = 55^2 = 3025
  *
  * Hence the difference between the sum of the squares of the first ten
  * natural numbers and the square of the sum is 3025 − 385 = 2640.
  *
  * Find the difference between the sum of the squares of the first one
  * hundred natural numbers and the square of the sum.
  */
object Problem6 {

  def solve(): Long = {

    def sumOfSquares(ns: Seq[Int]): Int = ns.map(Math.pow(_, 2)).sum.toInt

    def squareOfSum(ns: Seq[Int]): Int = Math.pow(ns.sum, 2).toInt

    squareOfSum(1 to 100) - sumOfSquares(1 to 100)
  }
}
