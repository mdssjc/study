package com.github.mdssjc.algorithms.chapter1.section12;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {

  public static void main(final String[] args) {
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

    StdOut.println(heads);
    StdOut.println(tails);

    final int d = heads.tally() - tails.tally();
    StdOut.println("delta: " + Math.abs(d));
  }
}
