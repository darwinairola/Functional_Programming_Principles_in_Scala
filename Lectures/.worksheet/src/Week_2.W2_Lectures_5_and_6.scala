package Week_2

object W2_Lectures_5_and_6
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  val x = new Rational(1, 3);System.out.println("""x  : Week_2.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : Week_2.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : Week_2.Rational = """ + $show(z ));$skip(7); val res$0 = 

  x.n;System.out.println("""res0: Int = """ + $show(res$0));$skip(6); val res$1 = 
  x.d;System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 
  
  x.add(y);System.out.println("""res2: Week_2.Rational = """ + $show(res$2));$skip(21); val res$3 = 
  
  x.sub(y).sub(z);System.out.println("""res3: Week_2.Rational = """ + $show(res$3));$skip(14); val res$4 = 
  
  y.add(y);System.out.println("""res4: Week_2.Rational = """ + $show(res$4))}
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
