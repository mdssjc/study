package com.github.mdssjc.algorithms.assignments.loops;

public class Bits {

  public static void main(final String[] args) {
    int n = Integer.parseInt(args[0]);

    if (n < 0) {
      System.out.println("Illegal input");
    } else {
      int count = 0;
      while (n > 0) {
        n /= 2;
        count++;
      }
      System.out.println(count);
    }
  }
}
