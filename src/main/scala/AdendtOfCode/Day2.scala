package AdendtOfCode

object Day2 {
  var depth =0
  var horizontal = 0

  def instruction(word:String,value :Int) ={
    word match {
      case "forward" => horizontal += value
      case "up" => depth -= value
      case "down" =>  depth += value
    }


  }
  def handler(input: List[String]):Int ={
    compute(input)
    depth * horizontal

  }
  def compute(input: List[String]) = {
    input.map(x => instruction( x.split(" ").head,x.split(" ").tail.head.toInt))

  }



}
