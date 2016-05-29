import scala.annotation.tailrec

def abs(x: Double): Double =
  if (x < 0) -x else x

def sqrt(x: Double): Double = {

  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double): Boolean =
    abs(guess * guess - x) / x < 0.001

  def improve(guess: Double): Double =
    (guess + x / guess) / 2

  sqrtIter(1.0)
}

sqrt(2)


def factorial(x: Int): Int = {
  @tailrec
  def factIter(x: Int, acc: Int): Int = {
    if (x == 0) acc
    else factIter(x - 1, x * acc)
  }

  factIter(x, 1)
}

factorial(3)