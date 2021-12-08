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


}
