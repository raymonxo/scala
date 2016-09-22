package raymitchell.euler.problems

import raymitchell.euler.util.Math._

/**
  * A palindromic number reads the same both ways. The largest palindrome made
  * from the product of two 2-digit numbers is 9009 = 91 × 99.
  *
  * Find the largest palindrome made from the product of two 3-digit numbers.
  */
object Problem4 {

  def solve(): Int =
    (for {
      a <- 100 to 999
      b <- 100 to 999
      c = a * b
      if c.isPalindromic
    } yield c).max
}
