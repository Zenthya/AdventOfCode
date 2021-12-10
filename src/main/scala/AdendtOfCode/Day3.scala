package AdendtOfCode

object Day3 {


  def getGammaSum(matrix :List[List[Int]]) :List[Int] ={

    if( matrix.head.tail.isEmpty  ) {

      List(matrix.map(_.head).sum)
    } else {

      List(matrix.map(_.head).sum) ::: getGammaSum(matrix.map(_.tail))
    }

  }

  def compute(input: List[String]) ={
     val gamma = getGammaSum(
       input.map(_.map(x => if (x == '1') 1 else -1).toList))
       .map(
         x => if (x < 0) "0" else "1"
       ).reduce(_+_)
    Integer.parseInt(gamma,2) * Integer.parseInt(gamma.map( x=> if(x=='0') "1" else "0" ).reduce(_+_),2)




  }
  def getStrongBitOxy(input: List[Int],n:Int) :Boolean= {
     if (input.count(x => {(x & n) == n}) >= input.count(x => {(x & n) != n}) )
       true
     else
       false

  }
  def getStrongBitCO2(input: List[Int],n:Int) :Boolean= {
    if (input.count(x => {(x & n) == n}) >= input.count(x => {(x & n) != n}) )
      false
    else
      true

  }

  def getOxygen(input: List[Int],n:Int):Int ={

    if(input.tail.isEmpty)
      input.head
    else
      if(getStrongBitOxy(input,n))
        getOxygen(input.filter(x => {(x & n) == n}),n>>1)
      else
        getOxygen(input.filter(x => {(x & n) != n}),n>>1)

  }


  def getCO2(input: List[Int],n:Int):Int ={
    if(input.tail.isEmpty)
      input.head
    else
      if(getStrongBitCO2(input,n))
        getCO2(input.filter(x => {(x & n) == n}),n>>1)
      else
        getCO2(input.filter(x => {(x & n) != n}),n>>1)
  }


  def computeBonus(input: List[String]) ={
    val n = input.head.length -1

    getCO2(input.map(Integer.parseInt(_,2)),1<<n) *getOxygen(input.map(Integer.parseInt(_,2)),1<<n)


  }


}
