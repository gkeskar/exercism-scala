object SecretHandshake {
  def commands(number: Int): List[String] = {
    val bits: List[Int] = List(1,2,4,8,16)
    bits.foldLeft(List[String]()){(acct,nextbit) => operationAndTransform(acct, nextbit, number)}
  }

  def operationAndTransform(result: List[String], nextbit: Int, number: Int): List[String] = {
    number match {
      case num if ((num & nextbit) == 1 ) => "wink" :: result
      case num if ((num & nextbit) == 2) =>  result ::: List("double blink")
      case num if ((num & nextbit) == 4) =>  result ::: List("close your eyes")
      case num if ((num & nextbit) == 8) =>  result ::: List("jump")
      case num if ((num & nextbit) == 16) =>  result.reverse
      case _ => result
    }
  }
}

