package raymitchell.euler.problems

/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143?
  */
object Problem3 {

  def solve(): Long = {
    var n = 600851475143l
    var candidate = 2l
    var lastFactor = n

    while (candidate <= n) {
      if (n % candidate == 0) {
        lastFactor = candidate
        n /= candidate
      } else {
        candidate += 1
      }
    }

    lastFactor
  }
}
