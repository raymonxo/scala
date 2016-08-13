package raymitchell.euler.util

/**
  * Iterable through all Fibonacci numbers.
  */
object FibonacciSequence extends Iterable[Int] {

  override def iterator: Iterator[Int] = new Iterator[Int] {

    var a = 1
    var b = 1

    override def hasNext: Boolean = true

    override def next(): Int = {

      val result = a
      a = b
      b = result + b
      result
    }
  }
}
