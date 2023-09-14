object Hamming {
  def distance(string1: String, string2: String): Option[Int] = {
    string1.length == string2.length match {
      case true => Some((string1).zip(string2).count { case (string1Char, string2Char) => string1Char != string2Char } )
      case false => None
    }
  }
}
