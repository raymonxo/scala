package raymitchell.euler.problems

/**
  * A palindromic number reads the same both ways. The largest palindrome made
  * from the product of two 2-digit numbers is 9009 = 91 × 99.
  *
  * Find the largest palindrome made from the product of two 3-digit numbers.
  */
object Problem4 {

  def solve(): Long = {

    def isPalindromicNumber(n: Int) = n.toString == n.toString.reverse

    (for {
      a <- 100 to 999
      b <- 100 to 999
      if isPalindromicNumber(a * b)
    } yield a * b).max
  }
}
