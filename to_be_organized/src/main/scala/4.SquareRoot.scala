/*
 * Implement the square root of a number
 *
 * Newton's method:
 *
 *   Take a guess and improve the guess by taking the mean of guess and x/guess recursively
 *
 */

import scala.math.abs

def squareRoot(x: Double): Double = {

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough) guess
    else sqrtIter(improveGuess(guess: Double, x: Double), x)
  }

  def isGoodEnough(guess: Double, x: Double) = {
    abs(guess * guess - x) / x > 0.001  // dividing by x adds proportion to the comparison 
    // when the number is too small for 0.001 or way too large to end iterations
  }

  def improveGuess(guess: Double, x: Double) = {
    (guess + x / guess) / 2
  }
  sqrtIter(1.0, x)
}

