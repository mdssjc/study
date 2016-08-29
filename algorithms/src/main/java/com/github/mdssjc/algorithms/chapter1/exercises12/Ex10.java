package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Exercício 10.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "10", "10" })
public class Ex10 {

  public static void main(final String[] args) {
    Executor.execute(Ex10.class, args);

    final int N = Integer.parseInt(args[0]);
    final int max = Integer.parseInt(args[1]);

    final VisualCounter vc = new VisualCounter(N, max);
    for (int i = 0; i < N; i++) {
      if (StdRandom.bernoulli()) {
        vc.increment();
      } else {
        vc.decrement();
      }
    }

    try {
      Thread.sleep(5000);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }
}
