package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Harmonic.class, "Program 2.1.1 Harmonic numbers (revisited)");
    Executor.execute(Gaussian.class, "Program 2.1.2 Gaussian functions");
    Executor.execute(Coupon.class, "Program 2.1.3 Coupon collector (revisited)");
    Executor.execute(PlayThatTuneDeluxe.class, "Program 2.1.4 Play that tune (revisited)");
  }
}
