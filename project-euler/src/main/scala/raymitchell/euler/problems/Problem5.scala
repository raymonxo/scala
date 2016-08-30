package raymitchell.euler.problems

import raymitchell.euler.util.MathFunc

/**
  * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  *
  * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  */
object Problem5 {

  def solve(): Long = {
    1L to 20 reduce ((acc, n) => MathFunc.lcm(acc, n))
  }
}
