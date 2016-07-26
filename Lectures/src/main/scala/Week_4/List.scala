package Week_4

trait List[+T]
{
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend [U >: T] (elem: U): List[U] = new Cons(elem, this)
  /*
  def insert(x: T, xs: List[T]): List[T] = xs match
  {
    case Nil => List(x)
    case y :: ys =>
      if ( x <= y ) { x :: xs }
      else
      {
        // var list = Nil
        // for (e <- xs)
        // {
        //   if (x <= e) { list = list :: x :: e }
        //   else { list = list :: e }
        // }
        // list
        y :: insert(x, ys)
      }
  }
  */
}

class Cons[T]( val head: T, val tail: List[T] ) extends List[T]
{
  def isEmpty = false
}

object Nil extends List[Nothing]
{
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException( "Nil.head" )
  def tail: Nothing = throw new NoSuchElementException( "Nil.tail" )
}


object List
{

  def apply[T]() = Nil
  def apply[T]( x: T ): List[T] = new Cons( x, Nil )
  def apply[T]( x1: T, x2: T ): List[T] = new Cons(x1, new Cons(x2, Nil))

}

object test
{
  val x: List[String] = Nil
  //def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}