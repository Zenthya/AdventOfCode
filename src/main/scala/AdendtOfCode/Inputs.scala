package AdendtOfCode

import scala.io.Source

object Inputs {


  def read(filename :String) : List[String] = {
    val reader = Source.fromFile(filename)
    val fileContent = reader.getLines.toList
    reader.close
    fileContent

  }


}





