package Week_2

object Lectures_5_and_6
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 
  val x = new Rational(1, 3);System.out.println("""x  : Week_2.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : Week_2.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : Week_2.Rational = """ + $show(z ));$skip(7); val res$0 = 

  x.n;System.out.println("""res0: Int = """ + $show(res$0));$skip(6); val res$1 = 
  x.d;System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 
  
  x.add(y);System.out.println("""res2: Week_2.Rational = """ + $show(res$2));$skip(21); val res$3 = 
  
  x.sub(y).sub(z);System.out.println("""res3: Week_2.Rational = """ + $show(res$3));$skip(14); val res$4 = 
  
  y.add(y);System.out.println("""res4: Week_2.Rational = """ + $show(res$4));$skip(15); val res$5 = 
  
  x.less(y);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(14); val res$6 = 
  
  x.max(y);System.out.println("""res6: Week_2.Rational = """ + $show(res$6));$skip(21); val res$7 = 
  
  new Rational(2);System.out.println("""res7: Week_2.Rational = """ + $show(res$7));$skip(42); 
  
  val r = new Rational( 9999, 777777 );System.out.println("""r  : Week_2.Rational = """ + $show(r ));$skip(10); val res$8 = 
  r add r;System.out.println("""res8: Week_2.Rational = """ + $show(res$8));$skip(23); val res$9 = 

	new Rational(1, 2).n;System.out.println("""res9: Int = """ + $show(res$9))}

}

class Rational(num: Int, den: Int)
{
	require( 0 != den, "denominator must be nonzero" )

	//  second constructor
	def this(d: Int) = this(d, 1)

  private def gcd(a: Int, b: Int): Int = if (0 == b) a else gcd(b, a % b)
  private val g = gcd(num, den)
	def n = num / g   //  numerator
	def d = den / g   //  denominator
	
	def less(that: Rational) = this.n * that.d < that.n * this.d
	
	def max(that: Rational) = if ( this.less(that) ) that else this
	
	def add(that: Rational) =
		new Rational( n * that.d + that.n * d, d * that.d )
		
	def neg: Rational = new Rational( -n, d )
	
	def sub(that: Rational) = add(that.neg)

	override def toString = n + "/" + d

}
