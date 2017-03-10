package com.github.mdssjc.algorithms.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(QuickFindTestDrive.class, "Quick Find test drive");
    Executor.execute(QuickUnionTestDrive.class, "Quick Union test drive");
    Executor.execute(WeightedQuickUnionTestDrive.class, "Weighted Quick Union test drive");
  }
}
