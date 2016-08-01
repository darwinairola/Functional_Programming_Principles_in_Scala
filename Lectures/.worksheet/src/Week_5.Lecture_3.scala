package Week_5

object Lecture_3
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(686); 

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
 	};System.out.println("""msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]""");$skip(36); 

	val nums = List( 2, -4, 5, 7, 1 );System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(61); 
	val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(60); val res$0 = 

	//msort( nums )((x: Int, y: Int) => x < y)
	msort( nums );System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(82); val res$1 = 
	//msort( fruits )((x: String, y: String) => x.compareTo(y) < 0)
	msort( fruits );System.out.println("""res1: List[String] = """ + $show(res$1))}

}
