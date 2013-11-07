package sfti.chapter4

//-----------------------------------------------------------------------------
// Set up a map of prices for a number of gizmos that you covet. Then produce
// a second map with the same keys and the prices at a 10% discount.
//-----------------------------------------------------------------------------
object Problem1 {
  type Gizmo = String
  type Price = BigDecimal
  
  def adjustPrices(gizmoPrices: Map[Gizmo, Price], pricePercentage: Double): Map[Gizmo, Price] = {
    for ((gizmo, price) <- gizmoPrices)
      yield (gizmo, price * pricePercentage)
  }
  
  def apply() {
    // Arrange
    val gizmoPrices = Map[Gizmo, Price](
	      "Neca Toys Plush Figures - Gremlins" -> 16.85,
	      "Neca Gremlins Electronic Dancing Plush Doll Gizmo" -> 33.50,
	      "Funko Gizmo Pop" -> 10.29,
	      "Gizmo 6 inch plush from Gremlins" -> 14.99
	    )
    val pricePercentage = .9
    val expectedGizmoPrices = Map[Gizmo, Price](
	      "Neca Toys Plush Figures - Gremlins" -> 15.165,
	      "Neca Gremlins Electronic Dancing Plush Doll Gizmo" -> 30.15,
	      "Funko Gizmo Pop" -> 9.261,
	      "Gizmo 6 inch plush from Gremlins" -> 13.491
	    )
    
    // Act
	val adjustedGizmoPrices = adjustPrices(gizmoPrices, pricePercentage)
    
    // Assert
    assert(adjustedGizmoPrices == expectedGizmoPrices)
  }
}