package AdendtOfCode

object Result extends App  {

  //Day 1
  var inputDay1: List[String] = Inputs.read("ressources/input/Day1.txt")
  //var  test = List("125","365","789","210")
  println("Day1 answer :"+Day1.compute(inputDay1))


  //Day2
  var inputDay2: List[String] = Inputs.read("ressources/input/Day2.txt")
  println("Day2 answer :" +Day2.handler(inputDay2))

}
