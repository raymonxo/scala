package raymitchell.euler.problems

import scala.collection.mutable

/**
  * Starting in the top left corner of a 2×2 grid, and only being able to move
  * to the right and down, there are exactly 6 routes to the bottom right
  * corner.
  *
  * How many such routes are there through a 20×20 grid?
  */
object Problem15 {

  def solve: Long = paths(20, 20)

  private val Paths = mutable.Map[(Int, Int), Long]()

  private def paths(x: Int, y: Int): Long = {
    if (x == 0)      1
    else if (y == 0) 1
    else {
      if (!Paths.contains(x, y)) {
        // Number of paths is sum of paths followed to arrive here
        Paths += (x, y) -> (paths(x - 1, y) + paths(x, y - 1))
      }
      Paths(x, y)
    }
  }
}
