import scala.annotation.tailrec

object FlattenArray {
  def flatten(input: List[Any]): List[Any] = {
// without tail rec
//    input match {
//      case Nil => Nil
//      case (head:List[_])::tail => (flatten(head):::flatten(tail)).filter( _ != null )
//      case head::tail => (head::flatten(tail)).filter( _ != null )
//    }

    def _flatten(res: List[Any], rem: List[Any]):List[Any] = rem match {
      case Nil => res
      case (h:List[_])::Nil => _flatten(res, h)
      case (h:List[_])::tail => _flatten(res, h) ::: _flatten(List(),tail)
      case h::tail => _flatten(res:::List(h), tail)
    }
    _flatten(List(), input).filter(_ != null)

  }
}

