package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.1.3 Coupon collector (revisited).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("1000")
@TestDrive("10000")
@TestDrive("1000000")
public class Coupon {

  public static int getCoupon(final int n) {
    return (int) (Math.random() * n);
  }

  public static int collectCoupons(final int n) {
    final boolean[] isCollected = new boolean[n];
    int count = 0, distinct = 0;
    while (distinct < n) {
      final int r = getCoupon(n);
      count++;
      if (!isCollected[r]) {
        distinct++;
      }
      isCollected[r] = true;
    }
    return count;
  }

  public static void main(final String[] args) {
    Executor.execute(Coupon.class, args);

    final int n = Integer.parseInt(args[0]);
    final int count = collectCoupons(n);
    StdOut.println(count);
  }
}
