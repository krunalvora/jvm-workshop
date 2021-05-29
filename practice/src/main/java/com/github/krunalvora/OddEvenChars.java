package com.github.krunalvora;

import java.util.Scanner;

/*
Given a string, , of length  that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as 2
space-separated strings on a single line
 */

public class OddEvenChars {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();

    System.out.println(String.format("Input string: %s", s));

    StringBuilder evenS = new StringBuilder();
    StringBuilder oddS = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        evenS.append(s.charAt(i));
      } else {
        oddS.append(s.charAt(i));
      }
    }

    System.out.println(String.format("Output strings: %s %s", evenS.toString(), oddS.toString()));

  }
}
