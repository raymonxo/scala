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
    if (n == 0)             1
    else if (n < 0)         1 / pow(x, -n)
    else if (n % 2 == 0)    pow(pow(x, n / 2), 2)
    else                    x * pow(x, n - 1)
  }
  
  def apply() {
    assert(pow(5, 0) == 1)
    assert(pow(16, -2) == 4)
    assert(pow(2, 6) == 64)
    assert(pow(2, 7) == 128)
  }
}