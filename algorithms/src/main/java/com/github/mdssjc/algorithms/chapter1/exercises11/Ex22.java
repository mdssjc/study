package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import java.util.stream.IntStream;

/**
 * Exercise 22.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex22 {

  public static void main(final String[] args) {
    Executor.execute(Ex22.class, args);

    final int[] inputs = IntStream.range(0, 1000)
                                  .sorted()
                                  .toArray();
    BinarySearchRecursiveTraces.rank(5, inputs);
  }
}
