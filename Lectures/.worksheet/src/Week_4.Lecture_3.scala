package Week_4

object Lecture_3
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(565); 
	def queens(n: Int): Set[List[Int]] =
	{
		def placeQueens(k: Int): Set[List[Int]] =
		{
			if (k == 0) Set(List())
			else
			{
				for
				{
				  queens <- placeQueens(k - 1)
				  col <- 0 until n
				  if ( isSafe(col, queens) )
				} yield col :: queens
			}
		}
		def isSafe(col: Int, queens: List[Int]): Boolean =
		{
		  val row = queens.length
		  val queensWithRow = (row-1 to 0 by -1) zip queens
		  queensWithRow forall
		  {
		    case (r, c) => col != c && math.abs(col - c) != row - r
		  }
		}
		placeQueens(n)
	};System.out.println("""queens: (n: Int)Set[Week_4.List[Int]]""")}
}
