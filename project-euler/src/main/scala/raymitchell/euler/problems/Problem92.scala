package raymitchell.euler.problems

import scala.collection.mutable

/**
  * A number chain is created by continuously adding the square of the digits
  * in a number to form a new number until it has been seen before.
  *
  * For example,
  *
  * 44 → 32 → 13 → 10 → 1 → 1
  * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
  *
  * Therefore any chain that arrives at 1 or 89 will become stuck in an endless
  * loop. What is most amazing is that EVERY starting number will eventually
  * arrive at 1 or 89.
  *
  * How many starting numbers below ten million will arrive at 89?
  */
object Problem92 {

  def solve: Int =
    (1 until 10000000)
      .map(getChainEnd)
      .count(_ == 89)

  /**
    * Cache of previously calculated chain ends.
    */
  private val chainEnds = mutable.Map( 1 -> 1, 89 -> 89 )

  /**
    * Return the end of the chain starting at start.
    */
  private def getChainEnd(start: Int): Int = {

    // Return the sum of the squares of n's digits.
    def sumDigitSquares(n: Int): Int = {
      n.toString.map { c =>
        val d = c.asDigit
        d * d
      }.sum
    }

    // If the chain end has not been calculated before
    if (!chainEnds.contains(start)) {

      // Build the chain
      val chain = mutable.Queue(start)
      var next = start
      while (!chainEnds.contains(next)) {
        next = sumDigitSquares(next)
        chain += next
      }
      next = chainEnds(next)

      // Cache each link of the chain
      chain.foreach(n => chainEnds += (n -> next))
    }

    chainEnds(start)
  }
}
