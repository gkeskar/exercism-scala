import Bob.isQuestion

object Bob {
  def response(statement: String): String = {

    statement match {
      case statement if (yellingQuestion(statement)) => "Calm down, I know what I'm doing!"
      case statement if (yelling(statement)) =>  "Whoa, chill out!"
      case statement if (isQuestion(statement)) => "Sure."
      case statement if (isSilence(statement)) => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  def yellingQuestion(str: String): Boolean = str.matches("([A-Z]+\\s[A-Z]+)+\\?$")
  def yelling(str: String): Boolean = !str.exists(_.isLower) && str.exists(_.isLetter)
  def isQuestion(str: String): Boolean = str.trim.endsWith("?")
  //def isSilence(str: String): Boolean = str.matches("^\\s*$")
  def isSilence(str: String): Boolean = str.trim.isEmpty
}
