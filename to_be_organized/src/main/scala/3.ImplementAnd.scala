// Implement the and function without using &&

def &&(x: Boolean, y: =>  Boolean): Boolean = {
  if (x) then y else False
}
