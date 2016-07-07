package Week_2

//  Currying
object Lecture_2
{

	def mapReduce(f: Int => Int, op: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
	{
	  if ( a > b ) zero
	  else op( f(a), mapReduce( f, op, zero )(a+1, b) )
	}                                         //> mapReduce: (f: Int => Int, op: (Int, Int) => Int, zero: Int)(a: Int, b: Int)
                                                  //| Int

	def product( f: Int => Int )( a: Int, b: Int ): Int =
	 mapReduce(f, (x, y) => x * y, 1)(a, b)   //> product: (f: Int => Int)(a: Int, b: Int)Int
	//{
	//  if ( a > b ) 1
	//  else f(a) * product(f)(a+1, b)
	//}
	
	product( x => x * x )( 3, 4 )             //> res0: Int = 144


	def factorial( n: Int ): Int =
	{
	  product( x => x )( 1, n )
	}                                         //> factorial: (n: Int)Int

	factorial( 5 )                            //> res1: Int = 120

  

}