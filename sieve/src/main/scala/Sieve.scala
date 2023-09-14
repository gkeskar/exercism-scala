import scala.annotation.tailrec

object Sieve {
  def primes(in: Int): List[Int] = {

    def generateSieveList(list: List[Int]): List[Int] = {

      list headOption match {
        case None => list
        case Some(hd) => {
          hd :: generateSieveList(filterMultiplesOf(hd, list.tail))
        }
      }
    }

    def filterMultiplesOf(number: Int, list: List[Int]): List[Int] = {
      list match {
        case Nil => List()
        case hd :: tl =>  hd :: tl.filterNot(_ % number == 0)
      }
    }
    generateSieveList((2 to in).toList)
  }

}