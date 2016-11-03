package raymitchell.euler.problems

import scala.io.Source

/**
  * For a number written in Roman numerals to be considered valid there are
  * basic rules which must be followed. Even though the rules allow some
  * numbers to be expressed in more than one way there is always a "best" way
  * of writing a particular number.
  *
  * For example, it would appear that there are at least six ways of writing
  * the number sixteen:
  *
  * IIIIIIIIIIIIIIII
  * VIIIIIIIIIII
  * VVIIIIII
  * XIIIIII
  * VVVI
  * XVI
  *
  * However, according to the rules only XIIIIII and XVI are valid, and the
  * last example is considered to be the most efficient, as it uses the least
  * number of numerals.
  *
  * The 11K text file, roman.txt (right click and 'Save Link/Target As...'),
  * contains one thousand numbers written in valid, but not necessarily
  * minimal, Roman numerals; see About... Roman Numerals
  * (https://projecteuler.net/about=roman_numerals) for the definitive
  * rules for this problem.
  *
  * Find the number of characters saved by writing each of these in their
  * minimal form.
  *
  * Note: You can assume that all the Roman numerals in the file contain no
  * more than four consecutive identical units.
  */
object Problem89 {

  def solve: Int = {
    Source.fromURL(getClass.getResource("/p089_roman.txt"))
      .getLines
      .map(numeral => numeral.length - intToRoman(romanToInt(numeral)).length)
      .sum
  }

  // Roman digits
  case class Digit(name: String, value: Int)
  val Digits = Seq(
    Digit("M", 1000),
    Digit("CM", 900),
    Digit("D",  500),
    Digit("CD", 400),
    Digit("C",  100),
    Digit("XC",  90),
    Digit("L",   50),
    Digit("XL",  40),
    Digit("X",   10),
    Digit("IX",   9),
    Digit("V",    5),
    Digit("IV",   4),
    Digit("I",    1)
  )

  /**
    * Converts an Int to the most efficient Roman numeral.
    */
  private def intToRoman(value: Int): String = {
    var result = ""
    var remaining = value

    // Repeatedly extract the next largest roman digit until nothing is left
    while (remaining > 0) {
      val digit = Digits.find(remaining >= _.value).getOrElse(Digits.head)
      result += digit.name
      remaining -= digit.value
    }

    result
  }

  /**
    * Converts a Roman numeral to an Int.  Assumes the Roman numeral is
    * well-formed but not necessarily in the most efficient form.
    */
  private def romanToInt(roman: String): Int = {
    // Loop over all numerals to compute result
    var result = 0
    var i = 0
    while (i < roman.length) {
      // Get current and next numerals
      val current: Char = roman(i)
      val next: Option[Char] =
        if (i + 1 < roman.length) Some(roman(i + 1)) else None

      // Add value of current numeral to result
      result += (current match {
        case 'I' =>
          next match {
            case Some('V') => -1
            case Some('X') => -1
            case _ => 1
          }
        case 'V' => 5
        case 'X' =>
          next match {
            case Some('L') => -10
            case Some('C') => -10
            case _ => 10
          }
        case 'L' => 50
        case 'C' =>
          next match {
            case Some('D') => -100
            case Some('M') => -100
            case _ => 100
          }
        case 'D' => 500
        case 'M' => 1000
      })

      // Move to next numeral
      i += 1
    }

    result
  }
}
