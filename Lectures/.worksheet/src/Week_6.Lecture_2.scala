package Week_6

object Lecture_2
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
	def isPrime(n: Int) = (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(11); 
	val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(66); val res$0 = 
	((1 until n) map (i =>
		(1 until i) map (j => (i, j)))).flatten;System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(104); val res$1 = 
	(1 until n) flatMap (i =>
		(1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(129); val res$2 = 
                                                  
	for
	{
		i <- 1 until n
		j <- 1 until i
		if isPrime(i + j)
	} yield (i, j);System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(183); 

  //  dot product
	def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
	{
		require(xs.size == ys.size)
		(for
		 {
			 x <- xs
			 y <- ys
		 } yield ( x * y )).sum
	};System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""")}
}
