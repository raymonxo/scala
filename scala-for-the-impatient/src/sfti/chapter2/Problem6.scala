package sfti.chapter2

//-----------------------------------------------------------------------------
// Write a for loop for computing the product of the Unicode codes of all
// letters in a string. For example, the product of the characters in
// "Hello" is 825152896.
//-----------------------------------------------------------------------------
object Problem6 {
  def unicodeProduct(s: String): Int = {
    var product = 1
    for (ch <- s)
      product *= ch.toInt
    product
  }
  
  def apply() {
    assert(unicodeProduct("Hello") == 825152896)
  }
}