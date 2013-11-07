package sfti.chapter4

//-----------------------------------------------------------------------------
// Write a function ltEqGt(values: Array[Int], v: Int) that returns a triple
// containing count of values less than v, equal to v, and greater than v.
//-----------------------------------------------------------------------------
object Problem9 {
  def ltEqGt(xs: Array[Int], v: Int): (Int, Int, Int) = xs.foldLeft((0, 0, 0)) {
    (z, x) => (z._1 + (if (x < v) 1 else 0),
               z._2 + (if (x == v) 1 else 0),
               z._3 + (if (x > v) 1 else 0))
  }
  
  def test(xs: Array[Int], v: Int, expected: (Int, Int, Int)) {
    assert(ltEqGt(xs, v) == expected)
  }
  
  def apply() {
    test(Array[Int](), 0, (0, 0, 0))
    test(Array(5), 5, (0, 1, 0))
    test(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 5, (4, 1, 4))
    test(Array(5, 1, -9, 12, -14, 8, 8), 8, (4, 2, 1))
  }
}