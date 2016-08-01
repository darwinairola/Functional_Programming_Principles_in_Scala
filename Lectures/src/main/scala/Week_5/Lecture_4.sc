package Week_5

object Lecture_4
{

  def squareList1(xs: List[Int]): List[Int] = xs match
  {
  	case Nil => xs
  	case h :: t => h * h :: squareList1(t)
  }                                               //> squareList1: (xs: List[Int])List[Int]
  
  def squareList2(xs: List[Int]): List[Int] =
  	xs map (x => x * x)                       //> squareList2: (xs: List[Int])List[Int]

  val intList = List[Int]( 1, 2, 3, 4, 5)         //> intList  : List[Int] = List(1, 2, 3, 4, 5)
  
  squareList1( intList )                          //> res0: List[Int] = List(1, 4, 9, 16, 25)
  
  squareList2( intList )                          //> res1: List[Int] = List(1, 4, 9, 16, 25)


	val nums = List( 2, -4, 5, 7, 1 )         //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
	nums filter( x => x > 0 )                 //> res2: List[Int] = List(2, 5, 7, 1)
	nums filterNot( x => x > 0 )              //> res3: List[Int] = List(-4)
	nums partition( x => x > 0 )              //> res4: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))

	nums takeWhile( x => x > 0 )              //> res5: List[Int] = List(2)
	nums dropWhile( x => x > 0 )              //> res6: List[Int] = List(-4, 5, 7, 1)
	nums span ( x => x > 0 )                  //> res7: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

	def pack[T](xs: List[T]): List[List[T]] = xs match
	{
		case Nil => Nil
		case h :: t =>
			val ( first, remainder ) = xs span( x => h == x )
			first :: pack( remainder )
	}                                         //> pack: [T](xs: List[T])List[List[T]]

	val data = List( "a", "a", "a", "b", "c", "c", "a" )
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
	
	pack( data )                              //> res8: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 

	def encode[T](xs: List[T]): List[(T, Int)] =
	{
		pack(xs) map( ys => (ys.head, ys.length) )
	}                                         //> encode: [T](xs: List[T])List[(T, Int)]
	  /*
	  xs match {
		case Nil => Nil
		case h :: t =>
			val ( first, remainder ) = xs.span( x => h == x )
			( h, first.length ) :: encode( remainder )
	  }
		*/
	
	encode( data )                            //> res9: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}