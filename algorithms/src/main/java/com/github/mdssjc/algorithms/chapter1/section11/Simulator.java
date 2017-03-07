package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Euclid.class, "Euclid's algorithm");
    Executor.execute(BinarySearch.class, "Binary Search algorithm");
    Executor.execute(BinarySearchRecursive.class, "Binary Search Recursive algorithm");
    Executor.execute(RandomSeq.class, "RandomSeq - Sample StdOut client");
    Executor.execute(Average.class, "Average - Sample StdOut client");
  }
}
