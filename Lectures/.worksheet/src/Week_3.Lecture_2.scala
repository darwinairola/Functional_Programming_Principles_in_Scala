package Week_3

object Lecture_2
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(55); val res$0 = 
  new Rational(1, 2);System.out.println("""res0: Week_3.Rational = """ + $show(res$0));$skip(51); 
  
  def error(msg: String) = throw new Error(msg);System.out.println("""error: (msg: String)Nothing""");$skip(17); 
  
	val x = null;System.out.println("""x  : Null = """ + $show(x ));$skip(19); 
	val y: String = x;System.out.println("""y  : String = """ + $show(y ));$skip(26); val res$1 = 
	
	if (true) 1 else false;System.out.println("""res1: AnyVal = """ + $show(res$1));$skip(88); 

	//  single element "List"
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)Week_3.Cons[T]""");$skip(397); 

	def nth[T](index: Int, list: List[T]):T =
	{
		if ( 0 > index ) throw new IndexOutOfBoundsException( "nth: index must be greater than 0" )
		var i: Int = 0
		var elem = list
		while ( index > i )
		{
		  if ( elem.tail.isEmpty ) throw new IndexOutOfBoundsException( "nth: requested element " + index + " but list terminates at element " + i )
		  elem = elem.tail
		  i += 1
		}
		elem.head
  };System.out.println("""nth: [T](index: Int, list: Week_3.List[T])T""");$skip(91); 
  
  val list = new Cons( 1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Nil)))) );System.out.println("""list  : Week_3.Cons[Int] = """ + $show(list ));$skip(17); val res$2 = 
  nth( 0, list );System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
  nth( 3, list );System.out.println("""res3: Int = """ + $show(res$3));$skip(17); val res$4 = 
  nth( 4, list );System.out.println("""res4: Int = """ + $show(res$4))}
  //nth( -1, list )
  //nth( 5, list )
  
}
