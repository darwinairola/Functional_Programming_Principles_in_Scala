package Week_5

object Lecture_1
{

	def init[T](xs: List[T]): List[T] = xs match
	{
		case List() => throw new Error( "init() of empty list" )
		case List(x) => List()
		case y :: ys => y :: init( ys )
	}                                         //> init: [T](xs: List[T])List[T]
	
	def removeAt[T](n: Int, xs: List[T]): List[T] =
	{
		if ( 0 > n ) { throw new Error( "removeAt() negative index specified" ) }
		else if ( (0 == xs.length) || (xs.length < n) ) { xs }
	  //else { xs diff List(xs(n)) }
	  else { (xs take n) ::: (xs drop (n+1)) }
	}                                         //> removeAt: [T](n: Int, xs: List[T])List[T]
	
	removeAt( 1, List('a', 'b', 'c', 'd') )   //> res0: List[Char] = List(a, c, d)
	
	def flatten(xs: List[Any]): List[Any] = xs match
	{
	  /*
		var list = List[Any]()
	  xs foreach
		{
			_ match
			{
				case x:List[_] => list = list ::: flatten(x)
				case y => list = list :+ y
			}
		}
		list
		*/
		case List() => xs
		case (h:List[_]) :: t => flatten(h) ::: flatten(t)
		case h :: t => h :: flatten(t)
	}                                         //> flatten: (xs: List[Any])List[Any]
	
	flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res1: List[Any] = List(1, 1, 2, 3, 5, 8)

}