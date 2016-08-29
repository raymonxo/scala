package raymitchell.euler.util

/**
  * Iterable through all Fibonacci numbers.
  */
object FibonacciSequence extends Iterable[Long] {

  override def iterator: Iterator[Long] = new Iterator[Long] {
    var a = 1
    var b = 1

    override def hasNext: Boolean = true

    override def next(): Long = {
      val result = a
      a = b
      b = result + b
      result
    }
  }
}
