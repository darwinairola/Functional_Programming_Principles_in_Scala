package Week_4

object exprs
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(144); 
  def show(e: Expr) = e match
  {
  	case Number(x) x.toString
  	case Sum(l, r) => show(l) + " + " + show(r)
  };System.out.println("""show: (e: <error>)Unit""");$skip(43); val res$0 = 
  
  show( Sum(Number(1), Sum(Number(44) );System.out.println("""res0: <error> = """ + $show(res$0))}
}
