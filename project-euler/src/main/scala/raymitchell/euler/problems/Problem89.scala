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

  // Roman numerals
  private case class RomanNumeral(name: String, value: Int)
  private val RomanNumerals = Seq(
    RomanNumeral("I",    1),
    RomanNumeral("IV",   4),
    RomanNumeral("V",    5),
    RomanNumeral("IX",   9),
    RomanNumeral("X",   10),
    RomanNumeral("XL",  40),
    RomanNumeral("L",   50),
    RomanNumeral("XC",  90),
    RomanNumeral("C",  100),
    RomanNumeral("CD", 400),
    RomanNumeral("D",  500),
    RomanNumeral("CM", 900),
    RomanNumeral("M", 1000)
  )

  /**
    * Converts an Int to the most efficiently formed Roman numeral.
    */
  private def intToRoman(value: Int): String = {
    // Repeatedly extract the largest valued numeral until nothing is left
    val sortedNumerals = RomanNumerals.sortBy(-_.value)
    val result = new collection.mutable.StringBuilder
    var remaining = value
    while (remaining > 0) {
      val numeral = sortedNumerals
        .find(remaining >= _.value)
        .getOrElse(sortedNumerals.head)
      result.append(numeral.name)
      remaining -= numeral.value
    }
    result.toString
  }

  /**
    * Converts a Roman numeral to an Int.  Assumes the Roman numeral is
    * well-formed but not necessarily in the most efficient form.
    */
  private def romanToInt(value: String): Int = {
    // Repeatedly extract the longest named numeral from the front until
    // nothing is left
    val sortedNumerals = RomanNumerals.sortBy(-_.name.length)
    var result = 0
    var remaining = value
    while (remaining.length > 0) {
      val numeral = sortedNumerals
        .find(numeral => remaining.startsWith(numeral.name))
        .getOrElse(sortedNumerals.head)
      result += numeral.value
      remaining = remaining.drop(numeral.name.length)
    }
    result
  }
}
