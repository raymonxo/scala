import math._
import math.BigInt._
import scala.util._
import scala.collection.mutable.ArrayBuffer

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(131); 

  val x = 3;System.out.println("""x  : Int = """ + $show(x ));$skip(12); 
  var r = 2;System.out.println("""r  : Int = """ + $show(r ));$skip(35); 
  if (x > 0) { r = r * x; r -= 1 };$skip(4); val res$0 = 
  r;System.out.println("""res0: Int = """ + $show(res$0));$skip(11); val res$1 = 
  
  1 + 2;System.out.println("""res1: Int(3) = """ + $show(res$1));$skip(35); 
  
  val nums = new Array[Int](10);System.out.println("""nums  : Array[Int] = """ + $show(nums ));$skip(34); 
  val s = Array("Hello", "World");System.out.println("""s  : Array[String] = """ + $show(s ));$skip(19); 
  s(0) = "Goodbye";$skip(4); val res$2 = 
  s;System.out.println("""res2: Array[String] = """ + $show(res$2));$skip(32); 
  
  val b = ArrayBuffer[Int]();System.out.println("""b  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(b ));$skip(9); val res$3 = 
  b += 1;System.out.println("""res3: worksheet.b.type = """ + $show(res$3));$skip(20); val res$4 = 
  b += (1, 2, 3, 4);System.out.println("""res4: worksheet.b.type = """ + $show(res$4));$skip(25); val res$5 = 
  b ++= Array(8, 13, 21);System.out.println("""res5: worksheet.b.type = """ + $show(res$5));$skip(14); 
  b trimEnd 5;$skip(4); val res$6 = 
  b;System.out.println("""res6: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$6));$skip(20); 
  
  b.insert(2, 6);$skip(4); val res$7 = 
  b;System.out.println("""res7: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$7));$skip(26); 
  b.insert(2, 5, 5, 5, 5);$skip(4); val res$8 = 
  b;System.out.println("""res8: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$8));$skip(14); val res$9 = 
  b.remove(2);System.out.println("""res9: Int = """ + $show(res$9));$skip(4); val res$10 = 
  b;System.out.println("""res10: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$10));$skip(17); 
  b.remove(2, 3);$skip(4); val res$11 = 
  b;System.out.println("""res11: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$11));$skip(23); val res$12 = 
  (b toArray) toBuffer;System.out.println("""res12: scala.collection.mutable.Buffer[Int] = """ + $show(res$12));$skip(69); 
  
  for (i <- 0 until (b.length, 2)) {
    println(i + ": " + b(i))
  };$skip(33); val res$13 = 
  
  0 until (10, 2) reverse;System.out.println("""res13: scala.collection.immutable.Range = """ + $show(res$13));$skip(41); 
  
  for (elem <- b) {
    println(elem)
  };$skip(57); val res$14 = 
  
  for (elem <- b if elem % 2 == 0) yield 2 * elem;System.out.println("""res14: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$14));$skip(11); val res$15 = 
  
  b.sum;System.out.println("""res15: Int = """ + $show(res$15));$skip(11); val res$16 = 
  
  s.max;System.out.println("""res16: String = """ + $show(res$16));$skip(8); val res$17 = 
  s.min;System.out.println("""res17: String = """ + $show(res$17));$skip(14); val res$18 = 
  
  b.sorted;System.out.println("""res18: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$18));$skip(22); val res$19 = 
  
  b sortWith {_>_};System.out.println("""res19: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$19));$skip(37); 
  
  scala.util.Sorting.quickSort(s);$skip(4); val res$20 = 
  s;System.out.println("""res20: Array[String] = """ + $show(res$20));$skip(29); val res$21 = 

  b.sorted mkString " and ";System.out.println("""res21: String = """ + $show(res$21))}
}
