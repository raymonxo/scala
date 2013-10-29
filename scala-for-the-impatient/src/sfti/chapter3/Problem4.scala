package sfti.chapter3

import scala.collection.mutable.ArrayBuffer

//-----------------------------------------------------------------------------
// Given an array of integers, produce a new array that contains all positive
// values of the original array, in their original order, followed by all
// values that are zero or negative, in their original order.
//-----------------------------------------------------------------------------
object Problem4 {
  def partitionStable(xs: Array[Int], pivot: Int): Array[Int] = {
    val lt, gte = ArrayBuffer[Int]()

    for (x <- xs)
      if (x < pivot) lt += x
      else           gte += x
    
    (lt ++ gte).toArray
  }
  
  def test(xs: Array[Int], xsPartitioned: Array[Int]) {
    assert(partitionStable(xs, 0) sameElements xsPartitioned)
  }
  
  def apply() {
    test(Array[Int](), Array[Int]())
    test(Array(1), Array(1))
    test(Array(0), Array(0))
    test(Array(-1), Array(-1))
    test(Array(1, -2, 0, 3, -4), Array(-2, -4, 1, 0, 3))
  }
}