package Week_2

object Lectures_5_through_7
{
  val x = new Rational(1, 3)                      //> x  : Week_2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Week_2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Week_2.Rational = 3/2

  x.n                                             //> res0: Int = 1
  x.d                                             //> res1: Int = 3

  x + y                                           //> res2: Week_2.Rational = 22/21
  
  x - y - z                                       //> res3: Week_2.Rational = -79/42
  
  y + y                                           //> res4: Week_2.Rational = 10/7
  
  x < y                                           //> res5: Boolean = true
  
  x max y                                         //> res6: Week_2.Rational = 5/7
  
  new Rational(2)                                 //> res7: Week_2.Rational = 2/1
  
  val r = new Rational( 9999, 777777 )            //> r  : Week_2.Rational = 303/23569
  r + r                                           //> res8: Week_2.Rational = 606/23569

	new Rational(1, 2).n                      //> res9: Int = 1

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
	
	def < (that: Rational) = this.n * that.d < that.n * this.d
	
	def max(that: Rational) = if ( this < that ) that else this

	def +(that: Rational) =
		new Rational( n * that.d + that.n * d, d * that.d )
		
	def unary_- : Rational = new Rational( -n, d )

	def - (that: Rational) = this + -that

	override def toString = n + "/" + d

}