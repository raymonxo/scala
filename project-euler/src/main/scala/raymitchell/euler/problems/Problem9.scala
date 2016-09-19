package raymitchell.euler.problems

/**
  * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
  *
  * a^2 + b^2 = c^2
  * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
  *
  * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  * Find the product abc.
  */
object Problem9 {

  def solve(): Int =
    (for {
      a <- 0 to 1000
      b <- a + 1 to 1000 - a
      c <- b + 1 to 1000 - a - b
      if a * a + b * b == c * c
      if a + b + c == 1000
    } yield a * b * c)
      .head
}
