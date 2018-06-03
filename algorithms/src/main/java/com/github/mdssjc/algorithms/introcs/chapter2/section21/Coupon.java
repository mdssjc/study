package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.1.3 Coupon collector (revisited).
 * <p>
 * Compilation:  javac Coupon.java
 * Execution:    java Coupon n
 * <p>
 * % java Coupon 1000
 * 6522
 * <p>
 * % java Coupon 1000
 * 6481
 * <p>
 * % java Coupon 1000000
 * 12783771
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("1000")
@TestDrive("1000000")
public class Coupon {

  public static int getCoupon(final int n) {
    return (int) (Math.random() * n);
  }

  public static int collect(final int n) {
    final var isCollected = new boolean[n];
    var count = 0;
    var distinct = 0;

    while (distinct < n) {
      final var value = getCoupon(n);
      count++;
      if (!isCollected[value]) {
        distinct++;
        isCollected[value] = true;
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    Executor.execute(Coupon.class, args);

    final var n = Integer.parseInt(args[0]);
    final var count = collect(n);
    StdOut.println(count);
  }
}
