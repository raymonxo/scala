package sfti.chapter2

//-----------------------------------------------------------------------------
// Solve the preceding problem without writing a loop. (Hint: Look at the
// StringOps Scaladoc.)
//-----------------------------------------------------------------------------
object Problem7 {
  def unicodeProduct(s: String): Int = {
    s.map(_.toInt).product
  }

  def apply() {
    assert(unicodeProduct("Hello") == 825152896)
  }
}