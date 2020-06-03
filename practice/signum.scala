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
