package com.github.mdssjc.algorithms.chapter1.exercises11;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Fibonacci {

  private static final Map<Integer, Long> cache = new HashMap<>();

  public static long f(final int n) {
    if (n == 0) {
      return 0L;
    }
    if (n == 1) {
      return 1L;
    }

    if (Fibonacci.cache.containsKey(n)) {
      return Fibonacci.cache.get(n);
    }

    final long value = f(n - 1) + f(n - 2);
    Fibonacci.cache.put(n, value);
    return value;
  }
}
