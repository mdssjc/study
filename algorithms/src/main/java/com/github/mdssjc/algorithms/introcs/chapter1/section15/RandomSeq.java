package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.5.1 Generating a random sequence.
 * <p>
 * Compilation:  javac RandomSeq.java
 * Execution:    java RandomSeq n
 * <p>
 * Prints n random real numbers between 0 and 1.
 * <p>
 * % java RandomSeq 5
 * 0.1654760343787165
 * 0.6212262060326124
 * 0.631755596883274
 * 0.4165639935584283
 * 0.4603525361488371
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("5")
public class RandomSeq {

  public static void main(final String[] args) {
    Executor.execute(RandomSeq.class, args);

    final var n = Integer.parseInt(args[0]);

    for (var i = 0; i < n; i++) {
      System.out.println(Math.random());
    }
  }
}
