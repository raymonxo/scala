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
      .map(getNumberChainEnd)
      .count(_ == 89)

  // Map from each number chain's first number to the chain's ending
  private val NumberChainEnds = mutable.Map( 1 -> 1, 89 -> 89 )

  private val MaxLink = sumDigitSquares(9999999)

  /**
    * Return the sum of the squares of n's digits
    */
  def sumDigitSquares(n: Int): Int = {
    n.toString.map { c =>
      val d = c.asDigit
      d * d
    }.sum
  }

  /**
    * Return the ending of the chain starting at begin
    */
  private def getNumberChainEnd(begin: Int): Int = {
    var link = begin

    // If the chain has not been calculated before
    if (!NumberChainEnds.contains(link)) {

      // Build the chain
      val chain =
        if (link <= MaxLink) mutable.Queue(link)
        else                 new mutable.Queue[Int]
      while (!NumberChainEnds.contains(link)) {
        link = sumDigitSquares(link)
        chain += link
      }
      link = NumberChainEnds(link)

      // Cache each link of the chain
      chain.foreach(n => NumberChainEnds += n -> link)
    }

    NumberChainEnds(link)
  }
}
