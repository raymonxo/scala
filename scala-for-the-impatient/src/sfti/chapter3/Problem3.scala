package sfti.chapter3

//-----------------------------------------------------------------------------
// Repeat the preceding assignment, but produce a new array with the swapped
// values. Use for/yield.
//-----------------------------------------------------------------------------
object Problem3 {
  def swapAdjacent[A](xs: Array[A]) = {
    val len = xs.length
    for (i <- 0 until len)
      yield
        if (len == 1)          xs(0)      // Only element, yield
        else if (i % 2 == 1)   xs(i - 1)  // Odd index, yield previous
        else if (i == len - 1) xs(i)      // Even last index, yield (nothing to swap)
        else                   xs(i + 1)  // Even index, yield next
  }
  
  def test[A](xs: Array[A], xsSwapped: Array[A]) {
    assert(swapAdjacent(xs) sameElements xsSwapped)
  }
  
  def apply() {
    test(Array[Int](), Array[Int]())
    test(Array(1), Array(1))
    test(Array(1, 2, 3, 4), Array(2, 1, 4, 3))
    test(Array(1, 2, 3, 4, 5), Array(2, 1, 4, 3, 5))
  }
}