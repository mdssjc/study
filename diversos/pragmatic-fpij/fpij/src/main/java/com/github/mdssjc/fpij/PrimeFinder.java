package com.github.mdssjc.fpij;

import java.util.stream.IntStream;

public class PrimeFinder {

  public static boolean isPrime(final int number) {
    return number > 1 &&
        IntStream.rangeClosed(2, (int) Math.sqrt(number))
                 .noneMatch(divisor -> number % divisor == 0);
  }
}
