import math._
import math.BigInt._
import scala.util._
import scala.collection.mutable.ArrayBuffer

object worksheet {

  val x = 3                                       //> x  : Int = 3
  var r = 2                                       //> r  : Int = 2
  if (x > 0) { r = r * x; r -= 1 }
  r                                               //> res0: Int = 5
  
  1 + 2                                           //> res1: Int(3) = 3
  
  val nums = new Array[Int](10)                   //> nums  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  val s = Array("Hello", "World")                 //> s  : Array[String] = Array(Hello, World)
  s(0) = "Goodbye"
  s                                               //> res2: Array[String] = Array(Goodbye, World)
  
  val b = ArrayBuffer[Int]()                      //> b  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  b += 1                                          //> res3: worksheet.b.type = ArrayBuffer(1)
  b += (1, 2, 3, 4)                               //> res4: worksheet.b.type = ArrayBuffer(1, 1, 2, 3, 4)
  b ++= Array(8, 13, 21)                          //> res5: worksheet.b.type = ArrayBuffer(1, 1, 2, 3, 4, 8, 13, 21)
  b trimEnd 5
  b                                               //> res6: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2)
  
  b.insert(2, 6)
  b                                               //> res7: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 6, 2)
  b.insert(2, 5, 5, 5, 5)
  b                                               //> res8: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 5, 5, 5,
                                                  //|  5, 6, 2)
  b.remove(2)                                     //> res9: Int = 5
  b                                               //> res10: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 5, 5, 5
                                                  //| , 6, 2)
  b.remove(2, 3)
  b                                               //> res11: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 6, 2)
  (b toArray) toBuffer                            //> res12: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, 1, 6, 2)
  
  for (i <- 0 until (b.length, 2)) {
    println(i + ": " + b(i))                      //> 0: 1
                                                  //| 2: 6
  }
  
  0 until (10, 2) reverse                         //> res13: scala.collection.immutable.Range = Range(8, 6, 4, 2, 0)
  
  for (elem <- b) {
    println(elem)                                 //> 1
                                                  //| 1
                                                  //| 6
                                                  //| 2
  }
  
  for (elem <- b if elem % 2 == 0) yield 2 * elem //> res14: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 4)
  
  b.sum                                           //> res15: Int = 10
  
  s.max                                           //> res16: String = World
  s.min                                           //> res17: String = Goodbye
  
  b.sorted                                        //> res18: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 6)
  
  b sortWith {_>_}                                //> res19: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(6, 2, 1, 1)
  
  scala.util.Sorting.quickSort(s)
  s                                               //> res20: Array[String] = Array(Goodbye, World)

  b.sorted mkString " and "                       //> res21: String = 1 and 1 and 2 and 6
}