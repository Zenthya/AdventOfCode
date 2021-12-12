package AdendtOfCode

object Day1 {


  def sign(value :Int) :Int= if (value < 0)  1 else 0
  def compute(input: List[String]) = {
    input.zip(input.tail).foldLeft(0)((acc, x) => acc + sign(x._1.toInt - x._2.toInt))
  }
  def bonus(input: List[String])   ={
    val res_input = input.zip(input.tail.zip(input.tail.tail)).map(x=> (x._1.toInt,x._2._1.toInt,x._2._2.toInt)).map(x => (x._1+x._2+x._3).toString)
    compute(res_input)
  }

}
