package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.chapter1.Counter;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Counter client that simulates t coin flips.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("10")
@TestDrive("10")
@TestDrive("1000000")
public class Flips {

  public static void main(final String[] args) {
    Executor.execute(Flips.class, args);

    final int trails = Integer.parseInt(args[0]);

    final Counter heads = new Counter("heads");
    final Counter tails = new Counter("tails");

    for (int t = 0; t < trails; t++) {
      if (StdRandom.bernoulli(0.5)) {
        heads.increment();
      } else {
        tails.increment();
      }
    }

    final int d = heads.tally() - tails.tally();
    StdOut.printf("%s%n%s%ndelta: %d%n", heads, tails, Math.abs(d));
  }
}
