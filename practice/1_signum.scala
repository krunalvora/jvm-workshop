/**
The signum of a number is 1 if the number is positive, -1 if it is negative, and 0 if it is zero. Write a function that computes this value.
*/

println("Enter an integer: ")
try {
  val input = scala.io.StdIn.readLine().toInt
  val signum = if (input > 0) 1 
             else (if (input < 0) -1 
                   else 0)
  println(s"The signum of the entered integer is: $signum")
} catch {
  case e: Exception => {
    println("An integer is required. Please try again.")
  }
}
