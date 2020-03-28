/*
 * Filter numbers greater than 10 in this list and return a list incrementing the filtered elements in the list by 1.
 *
 * (2, 4, 5, 9, 123, 34, 43)
 */

val myList = List(2, 4, 5, 9, 123, 34, 43)

val filteredList = myList.filter(_ > 10)

println(for(x <- filteredList) yield x + 1)
