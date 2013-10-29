package sfti.chapter3

//-----------------------------------------------------------------------------
// Write a loop that swaps adjacent elements of an array of integers. For
// example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
//-----------------------------------------------------------------------------
object Problem2 {
  def swapAdjacent[A](xs: Array[A]) {
    for (i <- 0 to xs.length - 2 by 2) {
      val temp = xs(i)
      xs(i) = xs(i + 1)
      xs(i + 1) = temp
    }
  }

  def test[A](xs: Array[A], xsSwapped: Array[A]) {
    swapAdjacent(xs)
    assert(xs sameElements xsSwapped)  // Compare contents, not refs
  }

  def apply() {
    test(Array[Int](), Array[Int]())
    test(Array(1), Array(1))
    test(Array(1, 2, 3, 4), Array(2, 1, 4, 3))
    test(Array(1, 2, 3, 4, 5), Array(2, 1, 4, 3, 5))
  }
}