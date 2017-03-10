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
    Executor.execute(TwoSum.class, "Brute-force two sum");
    Executor.execute(ThreeSum.class, "Brute-force three sum");
    Executor.execute(Stopwatch.class, "Timer (wall time)");
    Executor.execute(DoublingTest.class, "Doubling test");
    Executor.execute(TwoSumFast.class, "Faster two sum");
    Executor.execute(ThreeSumFast.class, "Faster three sum");
    Executor.execute(DoublingRatio.class);
  }
}
