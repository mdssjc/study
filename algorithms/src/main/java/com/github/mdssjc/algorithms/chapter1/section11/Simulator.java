package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.chapter1.section0.Average;
import com.github.mdssjc.algorithms.chapter1.section0.RandomSeq;
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
    Executor.execute(BinarySearchClient.class, "Binary Search client");
    Executor.execute(BinarySearchRecursiveClient.class, "Binary Search Recursive client");
    Executor.execute(RandomSeq.class, "Random numbers in a given range");
    Executor.execute(Average.class, "Average of a sequence of numbers");
  }
}
