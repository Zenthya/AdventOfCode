package AdendtOfCode

object Result extends App  {

  //Day 1
  var inputDay1: List[String] = Inputs.read("ressources/input/Day1.txt")
  //var  test = List("125","365","789","210")
  //println("Day1 answer :"+Day1.compute(inputDay1))


  //Day2
  var inputDay2: List[String] = Inputs.read("ressources/input/Day2.txt")
  //println("Day2 answer :" +Day2.handler(inputDay2))
  //println("Day2 bonus  answer :" +Day2.handlerBonus(inputDay2))

  //Day3
  val testDay3 = List("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010")
  val inputDay3: List[String] = Inputs.read("ressources/input/Day3.txt")
  //print("Day3 answer :" +Day3.compute(inputDay3))
  //println("Day3 answer bonus :"+

  //Day4
  val testDay4 =Inputs.read("ressources/testDay4.txt")
  val testDay4Tirage = List(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1).map(_.toString)
  val inputDay4 =Inputs.read("ressources/input/Day4.txt")
  val tirageDay4 = List(30,35,8,2,39,37,72,7,81,41,25,46,56,18,89,70,0,15,84,75,88,67,42,44,94,71,79,65,58,52,96,83,54,29,14,95,66,61,97,68,57,90,55,32,17,47,20,98,1,69,63,62,31,86,77,85,87,93,26,40,24,19,48,76,73,49,34,45,82,22,80,78,23,6,59,91,64,43,21,51,13,3,53,99,4,28,33,74,12,9,36,50,60,11,27,10,5,16,92,38).map(_.toString)
  //println(Day4.computeBonus(testDay4,testDay4Tirage))

  //println(Day4.compute(inputDay4,tirageDay4))
  println(Day4.computeBonus(inputDay4,tirageDay4))




}
