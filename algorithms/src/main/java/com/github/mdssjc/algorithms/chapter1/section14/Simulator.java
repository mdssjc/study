package com.github.mdssjc.algorithms.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(ThreeSum.class, "Brute-force three sum");
    Executor.execute(Stopwatch.class, "Timer (wall time)");
    Executor.execute(DoublingTest.class);
    Executor.execute(TwoSumFast.class);
    Executor.execute(ThreeSumFast.class);
    Executor.execute(DoublingRatio.class);
  }
}
