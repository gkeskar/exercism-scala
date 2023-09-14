

object SpaceAge {

  def spaceAgeFormula(input: Double, OrbitPeriodEarthYears: Double ) :Double = input/(OrbitPeriodEarthYears * 31557600)

  def onEarth(input: Double): Double = spaceAgeFormula(input,1)
  def onMercury(input: Double): Double = spaceAgeFormula(input,0.2408467 )
  def onVenus(input: Double): Double = spaceAgeFormula(input, 0.61519726)
  def onMars(input: Double): Double = spaceAgeFormula(input, 1.8808158)
  def onJupiter(input: Double): Double = spaceAgeFormula(input, 11.862615)
  def onSaturn(input: Double): Double = spaceAgeFormula(input, 29.447498)
  def onUranus(input: Double): Double = spaceAgeFormula(input, 84.016846)
  def onNeptune(input: Double): Double = spaceAgeFormula(input, 164.79132)
}
