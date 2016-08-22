package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * FlipsMax Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "1000000" })
public class FlipsMax {

  public static Counter max(final Counter x, final Counter y) {
    if (x.tally() > y.tally()) {
      return x;
    }
    return y;
  }

  public static void main(final String[] args) {
    Executor.test(FlipsMax.class, args);

    final int T = Integer.parseInt(args[0]);
    final Counter heads = new Counter("heads");
    final Counter tails = new Counter("tails");

    for (int t = 0; t < T; t++) {
      if (StdRandom.bernoulli(0.5)) {
        heads.increment();
      } else {
        tails.increment();
      }
    }

    if (heads.tally() == tails.tally()) {
      StdOut.println("Tie");
    } else {
      StdOut.println(max(heads, tails) + " wins");
    }
  }
}
