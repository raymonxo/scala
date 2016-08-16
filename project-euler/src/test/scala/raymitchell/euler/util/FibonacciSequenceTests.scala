package raymitchell.euler.util

import org.scalatest.{FlatSpec, Matchers}

class FibonacciSequenceTests extends FlatSpec with Matchers {

  "Fibonacci Sequence" should "start with the first 7 Fibonacci numbers" in {
    FibonacciSequence.take(7).toList should be (List(1, 1, 2, 3, 5, 8, 13))
  }
}
