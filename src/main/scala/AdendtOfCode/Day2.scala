package AdendtOfCode

object Day2 {
  var depth =0
  var horizontal = 0
  var aim = 0

  def instruction(word:String,value :Int) ={
    word match {
      case "forward" => horizontal += value
      case "up" => depth -= value
      case "down" =>  depth += value
    }}
  def bonusInstruction(wordBonus:String,value :Int)   ={
    wordBonus match {
      case "forward" => { horizontal += value
                          depth += value*aim                      }
      case "up" => aim -= value
      case "down" =>  aim += value

    }

  }



  def handler(input: List[String]):Int ={
    compute(input)
    depth * horizontal

  }
  def handlerBonus(input: List[String]):Int ={
    computeBonus(input)
    depth * horizontal

  }
  def compute(input: List[String]) = {
    input.map(x => instruction( x.split(" ").head,x.split(" ").tail.head.toInt))

  }
  def computeBonus(input: List[String]) = {
    input.map(x => bonusInstruction(x.split(" ").head, x.split(" ").tail.head.toInt))
  }



}
