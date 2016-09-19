package raymitchell.euler.problems

import raymitchell.euler.util.Math._

/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143?
  */
object Problem3 {

  def solve(): Long = 600851475143L.primeFactors.max
}
