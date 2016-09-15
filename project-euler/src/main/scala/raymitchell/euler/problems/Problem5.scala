package raymitchell.euler.problems

import raymitchell.euler.util.Math._

/**
  * 2520 is the smallest number that can be divided by each of the numbers from
  * 1 to 10 without any remainder.
  *
  * What is the smallest positive number that is evenly divisible by all of the
  * numbers from 1 to 20?
  */
object Problem5 {

  def solve(): Int =
    (1 to 20)
      .reduce((acc, n) => lcm(acc, n))
}
