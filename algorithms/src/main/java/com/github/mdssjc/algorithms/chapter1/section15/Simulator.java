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
    Executor.execute(QuickFindUFTestDrive.class);
    Executor.execute(QuickUnionUFTestDrive.class);
    Executor.execute(WeightedQuickUnionUFTestDrive.class);
  }
}
