package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * This class is a test suite for the methods in object FunSets. To run
  * the test suite, you can either:
  * - run the "test" command in the SBT console
  * - right-click the file in eclipse and chose "Run As" - "JUnit Test"
  */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
    * Link to the scaladoc - very clear and detailed tutorial of FunSuite
    *
    * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
    *
    * Operators
    * - test
    * - ignore
    * - pending
    */

  /**
    * Tests are written using the "test" operator and the "assert" method.
    */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
    * For ScalaTest tests, there exists a special equality operator "===" that
    * can be used inside "assert". If the assertion fails, the two values will
    * be printed in the error message. Otherwise, when using "==", the test
    * error message will only say "assertion failed", without showing the values.
    *
    * Try it out! Change the values so that the assertion fails, and look at the
    * error message.
    */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
    * When writing tests, one would often like to re-use certain values for multiple
    * tests. For instance, we would like to create an Int-set and have multiple test
    * about it.
    *
    * Instead of copy-pasting the code for creating the set into every test, we can
    * store it in the test class using a val:
    *
    * val s1 = singletonSet(1)
    *
    * However, what happens if the method "singletonSet" has a bug and crashes? Then
    * the test methods are not even executed, because creating an instance of the
    * test class fails!
    *
    * Therefore, we put the shared values into a separate trait (traits are like
    * abstract classes), and create an instance inside each test method.
    *
    */
  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "singletonSet" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "singletonSet", exchange the
    * function "ignore" by "test".
    */
  test("singletonSet(1) contains 1") {
    /**
      * We create a new instance of the "TestSets" trait, this gives us access
      * to the values "s1" to "s3".
      */
    new TestSets {
      /**
        * The string argument of "assert" is a message that is printed in case
        * the test fails. This helps identifying which assertion failed.
        */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("singletonSet(2) contains 2") {
    new TestSets {
      assert(contains(s2, 2))
    }
  }

  test("singletonSet(3) contains 3") {
    new TestSets {
      assert(contains(s3, 3))
    }
  }

  test("singletonSet(1) does not contain 2") {
    new TestSets {
      assert(!contains(s1, 2))
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val u = union(s1, s2)
      assert(contains(u, 1), "Union 1")
      assert(contains(u, 2), "Union 2")
      assert(!contains(u, 3), "Union 3")
    }
  }

  test("union with empty set yields original set") {
    new TestSets {
      val u = union(s1, emptySet)
      assert(contains(u, 1))
    }
  }

  test("intersect contains elements in each set") {
    new TestSets {
      val i = intersect(s1, s1)
      assert(contains(i, 1))
    }
  }

  test("intersect does not contain elements only in one set") {
    new TestSets {
      val i = intersect(s2, s3)
      assert(!contains(i, 2))
      assert(!contains(i, 3))
    }
  }

  test("intersect with empty set yields empty set") {
    new TestSets {
      val i = intersect(s1, emptySet)
      assert(!contains(i, 1))
    }
  }

  test("diff contains element in s1 but not in s2") {
    new TestSets {
      val d = diff(s1, s2)
      assert(contains(d, 1))
    }
  }

  test("diff does not contain element in s2 but not in s1") {
    new TestSets {
      val d = diff(s1, s2)
      assert(!contains(d, 2))
    }
  }

  test("diff does not contain element in s1 and s2") {
    new TestSets {
      val d = diff(s1, s1)
      assert(!contains(d, 1))
    }
  }

  test("filter contains element in s1 satisfying p") {
    new TestSets {
      val f = filter(s1, _ == 1)
      assert(contains(f, 1))
    }
  }

  test("filter does not contain element in s1 not satisfying p") {
    new TestSets {
      val f = filter(s1, _ == 2)
      assert(!contains(f, 1))
      assert(!contains(f, 2))
    }
  }

  test("forall true when all elements satisfy p") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(forall(s, x => x === 1 || x === 2 || x === 3))
    }
  }

  test("forall false when any element does not satisfy p") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(!forall(s, x => x === 1 || x === 2))
    }
  }

  test("exists true when any element satisfies p") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(exists(s, _ === 3))
    }
  }

  test("exists false when no element satisfies p") {
    new TestSets {
      val s = union(s1, s2)
      assert(!exists(s, _ === 3))
    }
  }

  test("map contains result of applying map function to each element") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val m = map(s, _ + 10)
      assert(contains(m, 11))
      assert(contains(m, 12))
      assert(contains(m, 13))
      assert(!contains(m, 1))
      assert(!contains(m, 2))
      assert(!contains(m, 3))
    }
  }
}
