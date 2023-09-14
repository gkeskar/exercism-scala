import scala.collection.mutable.Stack

object MatchingBrackets {
  def isPaired(string :String) :Boolean = {
    val str = string.replaceAll( "[^(){}\\[\\]]", "" )
    if (str.isEmpty)
      return true
    if (str.length % 2 != 0) {
      return false
    }

    else {
      println( str )
      val m = Map( "(" -> ")", "[" -> "]", "{" -> "}" )
      val brackets = Stack[Char]()
      str.filter(c=> c == '(' || c == '{' || c == '[').map(c => brackets.push(c))

      val firstChar = str.charAt( 0 )
      println( s"firstChar: $firstChar" )
      val closingBracket = m get (firstChar.toString)
      closingBracket match {
        case Some( closingBracket ) => {
          println( closingBracket( 0 ) )
          println( str.charAt( 1 ) )
          if (str.charAt( 1 ) == closingBracket( 0 )) {
            var s = str.drop( 2 )
            if (s.isEmpty) {
              return true
            }
            isPaired( s )
          }

          else if (str.endsWith( closingBracket )) {
            var s = str.drop( 1 ).dropRight( 1 )
            if (s.isEmpty) {
              return true
            }
            isPaired( s )
          }
          // did not find matching bracket
          else {
            false
          }
        }
        case None => false
      }
    }
  }
}
