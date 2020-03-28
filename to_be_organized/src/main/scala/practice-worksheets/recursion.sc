def reverse(x: String): String = {
  if (x.size < 2) x
  else reverse(x.tail) + x.head
}

reverse("head")

// use recursion to print all
def printAll(numbers: List[Int]): Unit = {
  // numbers.foreach(println)
  if (numbers.isEmpty) return
  else
    println(numbers.head)
    println()
    printAll(numbers.tail)
}

printAll(List(2, 3, 4, 5))


def isPalindrome(x: String): Boolean = {
    if (x.size < 2) true
    // The drop method takes an integer parameter N and will return a new collection that does not contain the first N elements.
    else (x.head == x.last) && isPalindrome(x.drop(1).dropRight(1))
}

isPalindrome("whatsup")
isPalindrome("oyo")


def raised(a: Int, b: Int): BigInt = {
    if (b == 0) 1
    else if (b == 1) a
    else a * raised(a, b-1)
}

raised(2, 3)


// Own implementation of map function - TODO
def myMapImplementation(x: List[Int])(y: Int => Int): List[Int] = {
    def accMap(x2: List[Int], acc: List[Int]): List[Int] = {
        if (x.isEmpty) acc
        else y(x2.head) :: accMap(x2.tail, acc)
    }
    accMap(x, List())
}

myMapImplementation(List(2,3,4))(x => x * 2)


