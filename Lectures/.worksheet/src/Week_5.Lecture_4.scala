package Week_5

object Lecture_4
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(158); 

  def squareList1(xs: List[Int]): List[Int] = xs match
  {
  	case Nil => xs
  	case h :: t => h * h :: squareList1(t)
  };System.out.println("""squareList1: (xs: List[Int])List[Int]""");$skip(72); 
  
  def squareList2(xs: List[Int]): List[Int] =
  	xs map (x => x * x);System.out.println("""squareList2: (xs: List[Int])List[Int]""");$skip(43); 

  val intList = List[Int]( 1, 2, 3, 4, 5);System.out.println("""intList  : List[Int] = """ + $show(intList ));$skip(28); val res$0 = 
  
  squareList1( intList );System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(28); val res$1 = 
  
  squareList2( intList );System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(37); 


	val nums = List( 2, -4, 5, 7, 1 );System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(61); 
	val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(27); val res$2 = 
	nums filter( x => x > 0 );System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(30); val res$3 = 
	nums filterNot( x => x > 0 );System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
	nums partition( x => x > 0 );System.out.println("""res4: (List[Int], List[Int]) = """ + $show(res$4));$skip(31); val res$5 = 

	nums takeWhile( x => x > 0 );System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(30); val res$6 = 
	nums dropWhile( x => x > 0 );System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(26); val res$7 = 
	nums span ( x => x > 0 );System.out.println("""res7: (List[Int], List[Int]) = """ + $show(res$7));$skip(177); 

	def pack[T](xs: List[T]): List[List[T]] = xs match
	{
		case Nil => Nil
		case h :: t =>
			val ( first, remainder ) = xs span( x => h == x )
			first :: pack( remainder )
	};System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(55); 

	val data = List( "a", "a", "a", "b", "c", "c", "a" );System.out.println("""data  : List[String] = """ + $show(data ));$skip(16); val res$8 = 
	
	pack( data );System.out.println("""res8: List[List[String]] = """ + $show(res$8));$skip(98); 

	def encode[T](xs: List[T]): List[(T, Int)] =
	{
		pack(xs) map( ys => (ys.head, ys.length) )
	};System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(182); val res$9 = 
	  /*
	  xs match {
		case Nil => Nil
		case h :: t =>
			val ( first, remainder ) = xs.span( x => h == x )
			( h, first.length ) :: encode( remainder )
	  }
		*/
	
	encode( data );System.out.println("""res9: List[(String, Int)] = """ + $show(res$9))}
}
