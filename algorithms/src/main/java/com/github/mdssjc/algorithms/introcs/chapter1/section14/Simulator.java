package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Sample.class, "Program 1.4.1 Sampling without replacement.");
    Executor.execute(CouponCollector.class, "Program 1.4.2 Coupon collector simulation.");
    Executor.execute(PrimeSieve.class, "Program 1.4.3 Sieve of Eratosthenes.");
    Executor.execute(SelfAvoidingWalk.class, "Program 1.4.4 Self-avoiding random walks.");
  }
}
