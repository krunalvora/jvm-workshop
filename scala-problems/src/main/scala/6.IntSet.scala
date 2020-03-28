abstract class IntSet {
  def incl(x: Int): Intset
  def contains(x: Int): Boolean
  def union(x: IntSet): IntSet
}


class Empty extends IntSet {
  override def toString = "."
  
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  
  def contains(x: Int): Boolean = false

  def union(x: IntSet): IntSet = x
}

class NonEmpty (elem: Int, left: IntSet, right: IntSet) extends IntSet {
  
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) left incl x
    else if (x > elem) right incl x
    else this
  }
  
  override def toString = "{" + left + elem + right + "}"

  // CONFUSING
  def union(that: IntSet): IntSet = ((this.left union this.right) union that) incl this.elem
}


val testIntSet = new NonEmpty(6, Empty, Empty)

