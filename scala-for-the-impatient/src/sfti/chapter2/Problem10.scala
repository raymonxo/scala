package sfti.chapter2

//-----------------------------------------------------------------------------
// Write a function that computes x^n, where n is an integer. Use the following
// recursive definition:
//
//    * x^n = y^2 if n is even and positive, where y = x^(n/2)
//    * x^n = x * x^(n-1) if n is odd and positive
//    * x^0 = 1
//    * x^n =  1 / x^(-n) if n is negative
//    * Don't use a return statement.
//-----------------------------------------------------------------------------
object Problem10 {
  def pow(x: Double, n: Int): Double = {
    if (n == 0)           1
    else if (n < 0)       1 / pow(x, -n)
    else if (n % 2 == 0)  { val y = pow(x, n / 2); y * y } 
    else                  x * pow(x, n - 1)
  }
  
  def apply() {
    assert(pow(5, 0) == 1)
    assert(pow(16, -2) == 0.00390625)
    assert(pow(2, 6) == 64)
    assert(pow(2, 7) == 128)
  }
}