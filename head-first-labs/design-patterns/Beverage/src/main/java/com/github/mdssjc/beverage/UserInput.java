package com.github.mdssjc.beverage;

import java.util.Scanner;

public class UserInput {

  private static Scanner in;

  public static String getUserInput(final String message) {
    if (in == null) {
      in = new Scanner(System.in);
    }

    System.out.printf("%s (y/n)? ", message);
    return in.next();
  }
}
