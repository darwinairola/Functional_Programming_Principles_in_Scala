package Week_5

object Lecture_5
{
 	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
 		(xs foldRight List[U]())((x, xs) => f(x) :: xs)
                                                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
		(xs foldLeft 0)( (sum, _) => sum + 1 )
                                                  //> lengthFun: [T](xs: List[T])Int
}