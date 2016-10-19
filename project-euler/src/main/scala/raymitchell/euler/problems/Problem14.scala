package raymitchell.euler.problems

import scala.collection.mutable

/**
  * The following iterative sequence is defined for the set of positive
  * integers:
  *
  * n → n/2 (n is even)
  * n → 3n + 1 (n is odd)
  *
  * Using the rule above and starting with 13, we generate the following
  * sequence:
  *
  * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
  *
  * It can be seen that this sequence (starting at 13 and finishing at 1)
  * contains 10 terms. Although it has not been proved yet (Collatz Problem),
  * it is thought that all starting numbers finish at 1.
  *
  * Which starting number, under one million, produces the longest chain?
  *
  * NOTE: Once the chain starts the terms are allowed to go above one million.
  */
object Problem14 {

  def solve: Long =
    (1L until 1000000L)
      .map(n => (n, getCollatzLength(n)))
      .maxBy(_._2)
      ._1

  // Map from each chain's first number to the chain's length
  private val CollatzLengths = mutable.Map { 1L -> 1L }

  /**
    * Return the length of the collatz sequence starting with begin
    */
  private def getCollatzLength(begin: Long): Long = {

    // If the chain has not been calculated before
    if (!CollatzLengths.contains(begin)) {

      // Build the chain up to a known link
      val chain = mutable.Queue(begin)
      var link = begin
      do {
        link =
          if (link % 2 == 0) link / 2
          else               3 * link + 1
        chain += link
      } while (!CollatzLengths.contains(link))

      // Cache length for each link of the chain
      chain
        .reverse
        .zipWithIndex
        .foreach {
          case (n, i) => CollatzLengths += (n -> (i + CollatzLengths(link)))
        }
    }

    CollatzLengths(begin)
  }
}
