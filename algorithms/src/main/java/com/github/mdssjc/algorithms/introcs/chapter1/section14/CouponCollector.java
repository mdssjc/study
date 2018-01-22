package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.2 Coupon collector simulation.
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

    final int n = Integer.parseInt(args[0]);
    final boolean[] isCollected = new boolean[n];
    int count = 0;
    int distinct = 0;

    while (distinct < n) {
      final int r = (int) (Math.random() * n);
      count++;
      if (!isCollected[r]) {
        distinct++;
        isCollected[r] = true;
      }
    }

    System.out.println(count);
  }
}
