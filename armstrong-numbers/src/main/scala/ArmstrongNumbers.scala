import scala.annotation.tailrec

object ArmstrongNumbers {
  def isArmstrongNumber(num: Int): Boolean = num == sumOfPowOfDigits(num)

  def sumOfPowOfDigits(num: Int): Double = {
    val numList = num.toString.map(_.asDigit)
    val power = numList.length
    numList.foldLeft(0.0)((accumulator,current) => r  + Math.pow(current,power) )
  }
}
