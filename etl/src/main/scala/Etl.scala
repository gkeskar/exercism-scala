

object Etl {

  def transform (oldScrableMap : Map[Int, Seq[String]]) : Map[String, Int] = {

    oldScrableMap.flatMap { case (score, letters) =>
      letters.map(
        letter =>
          (letter.map( _.toLower ), score)
      )
    }
  }
}

