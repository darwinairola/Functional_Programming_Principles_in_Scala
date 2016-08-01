package Week_5

object Lecture_5
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 
 	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
 		(xs foldRight List[U]())((x, xs) => f(x) :: xs);System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(81); 

  def lengthFun[T](xs: List[T]): Int =
		(xs foldLeft 0)( (sum, _) => sum + 1 );System.out.println("""lengthFun: [T](xs: List[T])Int""")}
}
