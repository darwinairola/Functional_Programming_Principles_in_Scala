package Week_3

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
