object Bearing {
  val North = 1
  val East = 2
  val South = 3
  val West = 4
}

case class Robot(bearing: Int, coordinates: (Int, Int)) {
  def turnRight: Robot = {
    bearing match {
      case Bearing.North => copy(Bearing.East, coordinates)
      case Bearing.East => copy(Bearing.South, coordinates)
      case Bearing.South => copy(Bearing.West, coordinates)
      case Bearing.West => copy(Bearing.North, coordinates)
    }
  }
  def turnLeft: Robot = {
    bearing match {
      case Bearing.North => copy(Bearing.West, coordinates)
      case Bearing.East => copy(Bearing.North, coordinates)
      case Bearing.South => copy(Bearing.East, coordinates)
      case Bearing.West => copy(Bearing.South, coordinates)
    }
  }

  def advance: Robot = bearing match {
    case Bearing.North =>
      copy(1, (coordinates._1 , coordinates._2 + 1))
    case Bearing.East =>
      copy(2, (coordinates._1 + 1 , coordinates._2 ))
    case Bearing.South =>
      copy(3, (coordinates._1 , coordinates._2 - 1))
    case Bearing.West =>
      copy(4, (coordinates._1 - 1 , coordinates._2 ))
  }

  def simulate(command: String): Robot = {
    val commandChars: List[Char] = command.toList
    commandChars.foldLeft(Robot(bearing,coordinates)) { (b, a) =>
      a match {
        case 'L' =>
          b.turnLeft
        case 'R' =>
          b.turnRight
        case 'A' =>
          b.advance
      }
    }
  }

}