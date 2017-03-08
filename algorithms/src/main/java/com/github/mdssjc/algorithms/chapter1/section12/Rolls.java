package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Counter client that simulates T rolls of a die.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000000")
public class Rolls {

  public static void main(final String[] args) {
    Executor.execute(Rolls.class, args);

    final int trails = Integer.parseInt(args[0]);
    final int SIDES = 6;
    final Counter[] rolls = new Counter[SIDES + 1];

    for (int i = 1; i <= SIDES; i++) {
      rolls[i] = new Counter(i + "'s");
    }

    for (int t = 0; t < trails; t++) {
      final int result = StdRandom.uniform(1, SIDES + 1);
      rolls[result].increment();
    }

    for (int i = 1; i <= SIDES; i++) {
      StdOut.println(rolls[i]);
    }
  }
}
