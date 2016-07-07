package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


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
   *   val s1 = singletonSet(1)
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
      assert(contains(s1, 1), "Singleton contains 1")
    }
  }
  
  test("singletonSet(1) does not contain 2")
  {
    new TestSets
    {
      assert( !contains(s1, 2), "Singleton does not contain 2" )
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test( "intersect contains only elements that are in both sets" )
  {
    new TestSets
    {
      val nothing = intersect(s1, s2)
      assert( !contains(nothing, 1), "Intersection of singletonSet(1) and singletonSet(2) contains nothing" )
      val oneValue = intersect( union(s1, s2), s1 )
      assert( contains(oneValue, 1), "Intersection of {1, 2} and {1} contains 1" )
      assert( !contains(oneValue, 2), "Intersection of {1, 2} and {1} does not contain 2" )
    }
  }
  
  test( "diff returns the difference between two sets" )
  {
    new TestSets
    {
      val diffOne = diff(s1, s2)
      assert( contains(diffOne, 1), "Difference of {1} and {2} contains 1" )
      assert( !contains(diffOne, 2), "Difference of {1} and {2} does not contain 2" )
      val diffTwo = diff(union(s1, s2), s1)
      assert( contains(diffTwo, 2), "Different of {1, 2} and {1} contains 2" )
      assert( !contains(diffTwo, 1), "Different of {1, 2} and {1} does not contain 1" )
    }
  }
  
  test( "filter returns only the elements of a set that are accepted by a given predicate, p" )
  {
    new TestSets
    {
      val filterOne = filter(s1, (x: Int) => x <= 5)
      assert( contains(filterOne, 1), "{1} and {all integers less than or equal to 5} contains 1" )
      assert( !contains(filterOne, 2), "{1} and {all integers less than or equal to 5} does not contain 2" )
      val filterTwo = filter(union(s1, s2), (x: Int) => x > 1)
      assert( contains(filterTwo, 2), "{1, 2} and {all integers greater than 1} contains 2" )
      assert( !contains(filterTwo, 1), "{1, 2} and {all integers greater than 1} does not contain 1" )
    }
  }
  
  test( "forall tests" )
  {
    new TestSets
    {
      assert( forall(s1, (x: Int) => x > 0), "{1} contains an element that is greater than 0" )
      assert( !forall(s1, (x: Int) => x > 1), "{1} does not contain an element that is greater than 1" )
    }
  }
  
  test( "exists tests" )
  {
    new TestSets
    {
      assert( exists(s1, (x: Int) => x > 0), "there exists an element in the set {1} that is greater than 0" )
      assert( !exists(s1, (x: Int) => x > 1), "there does not exists an element in the set {1} that is greater than 1" )
    }
  }

  test( "map function" )
  {
    new TestSets
    {
      val odd = union(s1, s3)
      val mapOddToEven = map(odd, (x: Int) => x + 1)
      assert( contains(mapOddToEven, 2) && contains(mapOddToEven, 4), "{2, 4} contains 2 and 4" )
      assert( !contains(mapOddToEven, 1) && !contains(mapOddToEven, 3), "{2, 4} does not contain 1 or 3" )
    }
  }

}
