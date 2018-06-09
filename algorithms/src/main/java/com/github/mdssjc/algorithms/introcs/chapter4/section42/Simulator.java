package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Questions.class, "Program 4.2.1 Binary search (20 questions)");
    Executor.execute(Gaussian.class, "Program 4.2.2 Bisection search");
    Executor.execute(BinarySearch.class, "Program 4.2.3 Binary search (sorted array)");
    Executor.execute(Insertion.class, "Program 4.2.4 Insertion sort");
    Executor.execute(InsertionTest.class, "Program 4.2.5 Doubling test for insertion sort");
    Executor.execute(Merge.class, "Program 4.2.6 Mergesort");
    Executor.execute(FrequencyCount.class, "Program 4.2.7 Frequency counts");
  }
}
