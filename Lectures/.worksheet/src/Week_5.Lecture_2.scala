package Week_5

object Lecture_2
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(465); 

	def msort(xs: List[Int]): List[Int] =
	{
		val n: Int = xs.length / 2
		if ( 0 == n ) { xs }
		else
		{
		  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match
  		{
  			case (Nil, _) => ys
  			case (_, Nil) => xs
  			case (xh :: xt, yh :: yt) =>
  				if ( xh < yh ) { xh :: merge( xt, ys ) } else { yh :: merge( xs, yt ) }
  		}
  		val (fst, snd) = xs splitAt n
  		merge( msort(fst), msort(snd) )
  	}
 	};System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(36); 

	val nums = List( 2, -4, 5, 7, 1 );System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(15); val res$0 = 
	msort( nums );System.out.println("""res0: List[Int] = """ + $show(res$0))}

}
