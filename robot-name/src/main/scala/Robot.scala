import scala.annotation.tailrec
import scala.collection.mutable.Set

class Robot {

  private var robotName:String = generateName()

  def name: String = robotName

  @tailrec
  private def generateName(): String = {
    val generatedName = randomAlpha ( 2 ) ++ randomNum ( 3 )

    checkName ( generatedName ) match {
      case None => {
        Robot.alreadySet += generatedName
        generatedName
      }
      case Some ( name ) => {
        this.generateName ()
      }
    }
  }

  def checkName ( name: String ) :Option[String] = {
    if (Robot.alreadySet contains name) {
      Some(name)
    }
    else {
      return None
    }
  }

  def randomStringFromCharList ( length: Int, chars: Seq[ Char ] ): String = {
    val sb = new StringBuilder
    for ( i <- 1 to length ) {
      val randomNum = util.Random.nextInt ( chars.length )
      sb.append ( chars ( randomNum ) )
    }
    sb.toString
  }

  def randomAlpha ( length: Int ): String = {
    val chars = ( 'A' to 'Z' )
    randomStringFromCharList ( length, chars )
  }

  def randomNum(length: Int): String = {
    val chars = ('0' to '9')
    randomStringFromCharList(length, chars)
  }

  def reset(): Unit = {
    robotName = generateName()

  }

}

object Robot {
  private var alreadySet = Set.empty[String]
}