package Week_5

object Lecture_1
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(205); 

	def init[T](xs: List[T]): List[T] = xs match
	{
		case List() => throw new Error( "init() of empty list" )
		case List(x) => List()
		case y :: ys => y :: init( ys )
	};System.out.println("""init: [T](xs: List[T])List[T]""");$skip(268); 
	
	def removeAt[T](n: Int, xs: List[T]): List[T] =
	{
		if ( 0 > n ) { throw new Error( "removeAt() negative index specified" ) }
		else if ( (0 == xs.length) || (xs.length < n) ) { xs }
	  //else { xs diff List(xs(n)) }
	  else { (xs take n) ::: (xs drop (n+1)) }
	};System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(43); val res$0 = 
	
	removeAt( 1, List('a', 'b', 'c', 'd') );System.out.println("""res0: List[Char] = """ + $show(res$0));$skip(330); 
	
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
	};System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(53); val res$1 = 
	
	flatten(List(List(1, 1), 2, List(3, List(5, 8))));System.out.println("""res1: List[Any] = """ + $show(res$1))}

}
