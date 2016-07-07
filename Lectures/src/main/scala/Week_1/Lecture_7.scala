package Week_1

object Lecture_7
{

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit =
  {

    def factorial(n: Int): Int =
    {
      def loop(acc: Int, n: Int): Int =
        if ( 0 == n ) acc
        else loop( acc * n, n - 1)
      loop(1, n)
    }   //  factorial()

    println( "factorial(4) = " + factorial(4) )

  }   //  main()

}   //  object Lecture_7
