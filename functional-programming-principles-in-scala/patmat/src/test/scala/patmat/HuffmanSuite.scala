package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
    val leaf = Leaf('a', 5)
    val fork = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(
      Fork(
        Leaf('a',2),
        Leaf('b',3),
        List('a','b'),
        5),
      Leaf('d',4),
      List('a','b','d'),
      9)
	}

  test("weight of a leaf") {
    new TestTrees {
      assert(weight(leaf) === 5)
    }
  }

  test("weight of a fork") {
    new TestTrees {
      assert(weight(fork) === 9)
    }
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a leaf") {
    new TestTrees {
      assert(chars(leaf) === List('a'))
    }
  }

  test("chars of a fork") {
    new TestTrees {
      assert(chars(fork) === List('a','b','d'))
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times non-empty list of chars") {
    assert(times(string2Chars("hello, world")) === List(('h', 1), ('e', 1), ('l', 3), ('o', 2), (',', 1), (' ', 1), ('w', 1), ('r', 1), ('d', 1)))
  }

  test("times empty list of chars") {
    assert(times(string2Chars("")) === Nil)
  }

  test("makeOrderedLeafList") {
    val ordered = makeOrderedLeafList(times(string2Chars("hello, world")))
    assert(ordered === List(Leaf('h', 1), Leaf('e', 1),  Leaf(',', 1), Leaf(' ', 1), Leaf('w', 1), Leaf('r', 1), Leaf('d', 1), Leaf('o', 2), Leaf('l', 3)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("singleton empty list") {
    assert(!singleton(Nil))
  }

  test("singleton 1 element list") {
    assert(singleton(List(Leaf('a', 1))))
  }

  test("singleton 2 element list") {
    assert(!singleton(List(Leaf('a', 1), Leaf('b', 1))))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode secret") {
    assert(decodedSecret.mkString === "huffmanestcool")
  }

  test("encode tree") {
    new TestTrees {
      assert(encode(t2)(string2Chars("adb")) === List(0, 0, 1, 0, 1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("codeBits") {
    val codes = List(('a', List(1,0,1)), ('b', List(0, 0)))

    assert(codeBits(codes)('a') === List(1,0,1))
    assert(codeBits(codes)('b') === List(0,0))
  }

  test("convert t1") {
    new TestTrees {
      assert(convert(t1) === List(('a', List(0)), ('b', List(1))))
    }
  }

  test("convert t2") {
    new TestTrees {
      assert(convert(t2) === List(('a', List(0, 0)), ('b', List(0, 1)), ('d', List(1))))
    }
  }

  test("quickEncode tree") {
    new TestTrees {
      assert(quickEncode(t2)(string2Chars("adb")) === List(0, 0, 1, 0, 1))
    }
  }

  test("decode and quickEncode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
