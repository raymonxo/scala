package raymitchell.euler.problems

import raymitchell.euler.util.Math._

/**
  * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
  * that the 6th prime is 13.
  *
  * What is the 10,001st prime number?
  */
object Problem7 {

  def solve(): Int =
    primeSequence
      .drop(10000)
      .head
}
