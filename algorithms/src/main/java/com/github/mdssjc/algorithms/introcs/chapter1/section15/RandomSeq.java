package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.5.1 Generating a random sequence.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000000")
public class RandomSeq {

  public static void main(final String[] args) {
    Executor.execute(RandomSeq.class, args);

    final int n = Integer.parseInt(args[0]);
    for (int i = 0; i < n; i++) {
      System.out.println(Math.random());
    }
  }
}
