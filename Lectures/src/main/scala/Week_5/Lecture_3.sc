package Week_5

object Lecture_3
{

  //def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] =
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] =
	{
		val n: Int = xs.length / 2
		if ( 0 == n ) { xs }
		else
		{
		  def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match
  		{
  			case (Nil, _) => ys
  			case (_, Nil) => xs
  			case (xh :: xt, yh :: yt) =>
  				//if ( lt(xh, yh) ) { xh :: merge( xt, ys ) } else { yh :: merge( xs, yt ) }
  				if ( ord.lt(xh, yh) ) { xh :: merge( xt, ys ) } else { yh :: merge( xs, yt ) }
  		}
  		val (fst, snd) = xs splitAt n
  		//merge( msort(fst)(lt), msort(snd)(lt) )
  		merge( msort(fst), msort(snd) )
  	}
 	}                                         //> msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]

	val nums = List( 2, -4, 5, 7, 1 )         //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	val fruits = List("apple", "pineapple", "orange", "banana")

	//msort( nums )((x: Int, y: Int) => x < y)
	msort( nums )                             //> res0: List[Int] = List(-4, 1, 2, 5, 7)
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
	//msort( fruits )((x: String, y: String) => x.compareTo(y) < 0)
	msort( fruits )                           //> res1: List[String] = List(apple, banana, orange, pineapple)

}