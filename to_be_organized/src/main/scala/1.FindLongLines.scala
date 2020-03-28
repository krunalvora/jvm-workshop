/* 
Print all the lines in a file that exceed the given width.

 `scala FindLongLines 45 <file>`

should print all the lines greater than width 45 in the file.
*/

import scala.io.Source

def processFile(name: String, width: Int) {
  def processLine(line: String) {
    if (line.length > width) println(line)
  }

  val source = Source.fromFile(name)
  for (line <- source.getLines()) {
    processLine(line)
  }
}

val width = args(0).toInt
val filename = args(1)
processFile(filename, width)

