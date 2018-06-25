package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Typical implementations of static methods.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TypicalStaticMethods {

  public static int abs(final int x) {
    if (x < 0) {
      return -x;
    } else {
      return x;
    }
  }

  public static double abs(final double x) {
    if (x < 0.0) {
      return -x;
    } else {
      return x;
    }
  }

  public static boolean isPrime(final int n) {
    if (n < 2) {
      return false;
    }
    for (var i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static double sqrt(final double c) {
    if (c < 0) {
      return Double.NaN;
    }
    final var err = 1e-15;
    var t = c;
    while (Math.abs(t - c / t) > err * t) {
      t = (c / t + t) / 2.0;
    }
    return t;
  }

  public static double hypotenuse(final double a, final double b) {
    return Math.sqrt(a * a + b * b);
  }

  public static double h(final int n) {
    var sum = 0.0;
    for (var i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    return sum;
  }

  public static void main(final String[] args) {
    Executor.execute(TypicalStaticMethods.class, args);

    StdOut.println("Absolute value of an int value");
    StdOut.println(abs(-1));
    StdOut.println(abs(1));

    StdOut.println("Absolute value of a double value");
    StdOut.println(abs(-1.23));
    StdOut.println(abs(1.23));

    StdOut.println("Primality test");
    StdOut.println(isPrime(1));
    StdOut.println(isPrime(2));
    StdOut.println(isPrime(3));
    StdOut.println(isPrime(4));

    StdOut.println("Square root (Newton's method)");
    StdOut.println(sqrt(2));
    StdOut.println(sqrt(4));

    StdOut.println("Hypotenuse of a right triangle");
    StdOut.println(hypotenuse(3, 4));

    StdOut.println("Harmonic number");
    StdOut.println(h(3));
  }
}
