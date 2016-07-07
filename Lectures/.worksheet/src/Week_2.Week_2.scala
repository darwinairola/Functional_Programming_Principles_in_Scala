package Week_2

object Week_2.Lectures_5_and_6
{
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.n
  x.d
  
  x.add(y)
  
  x.sub(y).sub(z)
  
  y.add(y)
}

class Rational(num: Int, den: Int)
{
	def n = num   //  numerator
	def d = den   //  denominator
	
	def add(that: Rational) =
		new Rational( n * that.d + that.n * d, d * that.d )
		
	def neg: Rational = new Rational( -n, d )
	
	def sub(that: Rational) = add(that.neg)

	override def toString = n + "/" + d
}
