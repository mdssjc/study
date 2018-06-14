package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.chapter1.section0.Counter;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Example of a static method with object arguments and return values.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000000")
public class FlipsMax {

  public static void main(final String[] args) {
    Executor.execute(FlipsMax.class, args);

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

    if (heads.tally() == tails.tally()) {
      StdOut.println("Tie");
    } else {
      StdOut.printf("%s wins%n", max(heads, tails));
    }
  }

  private static Counter max(final Counter x, final Counter y) {
    if (x.tally() > y.tally()) {
      return x;
    }
    return y;
  }
}
