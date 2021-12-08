package AdendtOfCode

object Day1 {


  def sign(value :Int) :Int= if (value < 0)  1 else 0
  def compute(input: List[String]) = {
     input.zip(input.tail).foldLeft(0)((acc,x)=> acc + sign(x._1.toInt -x._2.toInt))

}}
