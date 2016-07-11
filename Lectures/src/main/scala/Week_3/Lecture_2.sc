package Week_3

object Lecture_2
{
  new Rational(1, 2)                              //> res0: Week_3.Rational = 1/2
  
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
  
	val x = null                              //> x  : Null = null
	val y: String = x                         //> y  : String = null
	
	if (true) 1 else false                    //> res1: AnyVal = 1

	//  single element "List"
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)Week_3.Cons[T]

	def nth[T](index: Int, list: List[T]):T =
	{
		if ( 0 > index ) throw new IndexOutOfBoundsException( "nth: index must be greater than 0" )
		var i: Int = 0
		var elem = list
		while ( index > i )
		{
		  if ( elem.tail.isEmpty ) throw new IndexOutOfBoundsException( "nth: requested element " + index + " but list terminates at element " + i )
		  elem = elem.tail
		  i += 1
		}
		elem.head
  }                                               //> nth: [T](index: Int, list: Week_3.List[T])T
  
  val list = new Cons( 1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Nil)))) )
                                                  //> list  : Week_3.Cons[Int] = Week_3.Cons@6a5fc7f7
  nth( 0, list )                                  //> res2: Int = 1
  nth( 3, list )                                  //> res3: Int = 4
  nth( 4, list )                                  //> res4: Int = 5
  //nth( -1, list )
  //nth( 5, list )
  
}