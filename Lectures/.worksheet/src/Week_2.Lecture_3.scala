package Week_2

object Lecture_3
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(59); 

	val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(49); 
	
	def abs( x: Double ) = if ( 0 > x ) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(79); 

	def isCloseEnough(x: Double, y: Double) =
		abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(220); 

	def fixedPoint(f: Double => Double)(firstGuess: Double) =
	{
		def iterate(guess: Double): Double =
		{
			val next = f(guess)
			if (isCloseEnough(guess, next)) next
			else iterate(next)
		}
		iterate(firstGuess)
	};System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(67); 

	def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(72); 
	
	def sqrt( x: Double ) = fixedPoint( averageDamp(y => x / y) )( 1.0 );System.out.println("""sqrt: (x: Double)Double""");$skip(65); val res$0 = 
                                                  
  sqrt( 2.0 );System.out.println("""res0: Double = """ + $show(res$0))}

}
