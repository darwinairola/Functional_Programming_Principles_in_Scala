package Week_2

//  Currying
object Lecture_2
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(215); 

	def mapReduce(f: Int => Int, op: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
	{
	  if ( a > b ) zero
	  else op( f(a), mapReduce( f, op, zero )(a+1, b) )
	};System.out.println("""mapReduce: (f: Int => Int, op: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(97); 

	def product( f: Int => Int )( a: Int, b: Int ): Int =
	 mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(99); val res$0 = 
	//{
	//  if ( a > b ) 1
	//  else f(a) * product(f)(a+1, b)
	//}
	
	product( x => x * x )( 3, 4 );System.out.println("""res0: Int = """ + $show(res$0));$skip(69); 


	def factorial( n: Int ): Int =
	{
	  product( x => x )( 1, n )
	};System.out.println("""factorial: (n: Int)Int""");$skip(17); val res$1 = 

	factorial( 5 );System.out.println("""res1: Int = """ + $show(res$1))}

  

}
