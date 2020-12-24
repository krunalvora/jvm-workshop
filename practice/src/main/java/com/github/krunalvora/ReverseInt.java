package com.github.krunalvora;

public class ReverseInt {

  public static void main(String[] args) {
    int n = 512;
    System.out.println(reverseInt(n));
  }

  public static int reverseInt(int input) {
    int reversedInt = 0;
    while (input != 0) {
      reversedInt = reversedInt * 10 + input % 10;
      input = input / 10;
    }
    return reversedInt;
  }
}
