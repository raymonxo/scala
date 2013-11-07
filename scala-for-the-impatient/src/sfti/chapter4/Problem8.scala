package sfti.chapter4

import scala.math._

//-----------------------------------------------------------------------------
// Write a function minMax(values: Array[Int]) that returns a pair containing
// the smallest and largest values in the array.
//-----------------------------------------------------------------------------
object Problem8 {
  def minMax(xs: Array[Int]): (Int, Int) = xs.foldLeft((xs.head, xs.head)) {
    (z, x) => (min(x, z._1), max(x, z._2))
  }
  
  def test(xs: Array[Int], expectedMin: Int, expectedMax: Int) {
    val result = minMax(xs)
    assert(result._1 == expectedMin)
    assert(result._2 == expectedMax)
  }
  
  def apply() {
    test(Array(1), 1, 1)
    test(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 1, 9)
    test(Array(5, 1, -9, 12, -14), -14, 12)
  }
}