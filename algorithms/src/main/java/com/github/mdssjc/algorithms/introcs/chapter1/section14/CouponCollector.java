package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.2 Coupon collector simulation.
 * <p>
 * Compilation:  javac CouponCollector.java
 * Execution:    java CouponCollector n
 * <p>
 * Given n distinct card types, how many random cards do you need
 * do collect before you have (at least) one of each type?
 * This program simulates this random process.
 * <p>
 * <p>
 * % java CouponCollector 1000
 * 6583
 * <p>
 * % java CouponCollector 1000
 * 6477
 * <p>
 * % java CouponCollector 1000000
 * 12782673
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("1000")
@TestDrive("1000000")
public class CouponCollector {

  public static void main(final String[] args) {
    Executor.execute(CouponCollector.class, args);

    final var n = Integer.parseInt(args[0]);
    final var isCollected = new boolean[n];
    var count = 0;
    var distinct = 0;

    while (distinct < n) {
      final var value = (int) (Math.random() * n);
      count++;
      if (!isCollected[value]) {
        distinct++;
        isCollected[value] = true;
      }
    }

    System.out.println(count);
  }
}
