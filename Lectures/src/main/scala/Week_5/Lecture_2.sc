package Week_5

object Lecture_2
{

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
 	}                                         //> msort: (xs: List[Int])List[Int]

	val nums = List( 2, -4, 5, 7, 1 )         //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	msort( nums )                             //> res0: List[Int] = List(-4, 1, 2, 5, 7)

}