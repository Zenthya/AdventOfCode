package AdendtOfCode

object Day4 {

  case class BingoGrid(rows : List[List[Int]]){


    def getSum: Int = rows.flatMap(_.filter(_>0)).sum
    def isWinning : Boolean = {
      rows.map( x => {if(x.sum == -5) true else false}).max

    }

  }
  def checkValue(bingoGrid: BingoGrid,value:Int):BingoGrid= {
    if (bingoGrid.rows.tail.isEmpty)
      bingoGrid.copy(bingoGrid.rows.map(_.map(transform(_,value))))
    else
      bingoGrid.copy(List(bingoGrid.rows.head.map(transform(_,value))):::checkValue(bingoGrid.copy(bingoGrid.rows.tail),value).rows )

  }
  val transform : (Int,Int) => Int = (x:Int, n:Int) =>  { if( x ==n ) -1 else x}
  val digitIsString: String => Boolean = (x:String)=> {x.exists(_.isDigit)}

  val stringToRow :String => List[Int] =(x:String) =>{ x.split(" ").filterNot(_.isEmpty).map(_.toInt).toList}


  def parser(input:List[String]): List[BingoGrid] ={
    input.filter(digitIsString).map(stringToRow).grouped(5).toList.map(BingoGrid)

  }

  def findWinningGrid(bingoGrids :List[BingoGrid],tirage:List[Int]): (BingoGrid,Int) ={

    if (bingoGrids.map(checkValue(_,tirage.head)).exists(_.isWinning)) {
      println(bingoGrids.map(checkValue(_,tirage.head)).filter(_.isWinning).head.getSum)
      (bingoGrids.map(checkValue(_,tirage.head)).filter(_.isWinning).head,tirage.head)
    } else
      findWinningGrid(bingoGrids.map(checkValue(_,tirage.head)),tirage.tail)

  }

  def compute(inputbingoGrids :List[String],input:List[String]):Int   = {

    val winner: (BingoGrid,Int) = findWinningGrid(parser(inputbingoGrids),input.map(_.toInt))
    winner._2 * winner._1.getSum
  }




}
