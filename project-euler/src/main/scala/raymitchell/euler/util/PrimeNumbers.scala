package raymitchell.euler.util

/**
  * Iterable through all prime numbers.
  */
object PrimeNumbers extends Iterable[Long] {
  // Cache of previously computed primes
  // TODO: Make thread safe
  private var primes = Vector[Long]()

  override def iterator: Iterator[Long] = new Iterator[Long] {

    override def hasNext: Boolean = true

    override def next(): Long = {
      // A number is prime if it has no prime factors
      def isPrime(x: Long): Boolean = {
        primes.forall(x % _ != 0)
      }

      // Determine next prime
      val prime = primes.length match {
        case 0 => 2
        case 1 => 3
        case _ =>
          // Scan odd numbers above the last prime
          var x = primes.last + 2
          while (!isPrime(x)) {
            x += 2
          }
          x
      }

      // Cache the prime
      primes = primes :+ prime

      prime
    }
  }
}
