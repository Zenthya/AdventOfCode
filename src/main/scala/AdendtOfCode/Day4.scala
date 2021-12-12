package AdendtOfCode

import scala.annotation.tailrec
import scala.math.Ordering.Implicits.infixOrderingOps

object Day4 {

  case class BingoGrid(rows : List[List[Int]]){


    def getSum: Int = rows.flatMap(_.filter(_>0)).sum
    def isWinningRow :Boolean = {
      rows.map( x => {if(x.sum == -5) true else false}).max

    }
    def isWinningColumn :Boolean = {
      rows.indices.map(x => { if(rows.map(_(x)).sum == -5) true else false  }).max

    }
    def isWinning : Boolean = {
      isWinningRow max isWinningColumn

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

      (bingoGrids.map(checkValue(_,tirage.head)).filter(_.isWinning).head,tirage.head)
    } else
      findWinningGrid(bingoGrids.map(checkValue(_,tirage.head)),tirage.tail)

  }

  def compute(inputbingoGrids :List[String],input:List[String]):Int   = {

    val winner: (BingoGrid,Int) = findWinningGrid(parser(inputbingoGrids),input.map(_.toInt))
    winner._2 * winner._1.getSum
  }

  @tailrec
  def findLosingGrid(bingoGrids :List[BingoGrid], tirage:List[Int]): (BingoGrid,Int) ={
    val checkedBingoGrids = bingoGrids.map(checkValue(_,tirage.head))
    if (checkedBingoGrids.length == 1  && checkedBingoGrids.exists(_.isWinning)) {

      (checkValue(checkedBingoGrids.head,tirage.head),tirage.head)
    } else {
      findLosingGrid(bingoGrids.map(checkValue(_, tirage.head)).filterNot(_.isWinning), tirage.tail)
    }
  }

  def computeBonus(inputBingoGrids :List[String],input:List[String]):Int   = {

    val winner: (BingoGrid,Int) = findLosingGrid(parser(inputBingoGrids),input.map(_.toInt))
    winner._2 * winner._1.getSum
  }



}
