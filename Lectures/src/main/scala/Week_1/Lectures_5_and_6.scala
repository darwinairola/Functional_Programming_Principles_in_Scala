package Week_1

object Lectures_5_and_6
{

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit =
  {

    println( "1+2 = " + (1+2) )

    def abs(x: Double) = if ( x < 0) -x else x

    def sqrt(x: Double) =
    {
      def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))

      def isGoodEnough(guess: Double) =
        abs(guess * guess - x) < ( 0.001 * x )
    
      def improve(guess: Double) =
        (guess + x / guess) / 2
    
      sqrtIter( 1.0 )
    }   //  sqrt()

    println( "sqrt(2) = " + sqrt(2) )
    println( "sqrt(4) = " + sqrt(4) )
    println( "sqrt(1e-6) = " + sqrt(1e-6) )
    println( "sqrt(1e60) = " + sqrt(1e60) )

    println( "sqrt(0.001) = " + sqrt(0.001) )
    println( "sqrt(0.1e-20) = " + sqrt(0.1e-20) )
    println( "sqrt(1.0e20) = " + sqrt(1.0e20) )
    println( "sqrt(1.0e50) = " + sqrt(1.0e50) )

  }   //  main()

}   //  object Lectures_5_and_6
