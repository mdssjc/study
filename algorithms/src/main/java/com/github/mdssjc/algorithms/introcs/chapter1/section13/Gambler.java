package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.8 Gambler’s ruin simulation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"10", "20", "1000"})
@TestDrive({"10", "20", "1000"})
@TestDrive({"50", "250", "100"})
@TestDrive({"500", "2500", "100"})
public class Gambler {

  public static void main(final String[] args) {
    Executor.execute(Gambler.class, args);

    final int stake = Integer.parseInt(args[0]);
    final int goal = Integer.parseInt(args[1]);
    final int trials = Integer.parseInt(args[2]);
    int bets = 0;
    int wins = 0;
    for (int t = 0; t < trials; t++) {
      int cash = stake;
      while (cash > 0 && cash < goal) {
        bets++;
        if (Math.random() < 0.5) {
          cash++;
        } else {
          cash--;
        }
      }
      if (cash == goal) {
        wins++;
      }
    }
    System.out.println(100 * wins / trials + "% wins");
    System.out.println("Avg # bets: " + bets / trials);
  }
}
