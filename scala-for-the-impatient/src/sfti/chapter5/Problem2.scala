package sfti.chapter5

//-----------------------------------------------------------------------------
// Write a class BankAccount with methods deposit and withdraw, and a read-only
// property balance.
//-----------------------------------------------------------------------------
class BankAccount {
  private var _balance: BigDecimal = 0;
  
  def balance = _balance
  
  def deposit(amount: BigDecimal) {
    require(amount > 0)
    _balance += amount
  }
  
  def withdraw(amount: BigDecimal) {
    require(amount > 0)
    require(_balance - amount >= 0)
    _balance -= amount
  }
}

object Problem2 {
  def apply() {
    // Arrange
    val bankAccount = new BankAccount
    
    // Act
    bankAccount.deposit(500)
    bankAccount.withdraw(200)
    
    // Assert
    assert(bankAccount.balance == 300)
  }
}
