import scala.collection.immutable.SortedMap

class School {
  type DB = Map[Int, Seq[String]]
  private var students: DB = SortedMap[Int, Seq[String]]().withDefaultValue(Seq.empty)

  def add(name: String, g: Int) = {
    students = students.updated(g , students(g) :+ name)
  }

  def db: DB = students

  def grade(g: Int): Seq[String] = students(g)

  def sorted: DB = {
    students.mapValues(_.sorted)
  }

}
