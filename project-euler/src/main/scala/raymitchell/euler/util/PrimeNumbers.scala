package raymitchell.euler.util

/**
  * Iterable through all prime numbers.
  */
object PrimeNumbers extends Iterable[Int] {
  // Cache of previously computed primes
  // TODO: Make thread safe
  private var primes = Vector[Int]()

  override def iterator: Iterator[Int] = new Iterator[Int] {

    override def hasNext: Boolean = true

    override def next(): Int = {
      // A number is prime if it has no prime factors
      def isPrime(x: Int): Boolean = {
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
