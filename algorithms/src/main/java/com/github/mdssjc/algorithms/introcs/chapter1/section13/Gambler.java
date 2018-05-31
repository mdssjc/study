package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.8 Gambler’s ruin simulation.
 * <p>
 * Compilation:  javac Gambler.java
 * Execution:    java Gambler stake goal N
 * <p>
 * Simulates a gambler who start with $stake and place fair $1 bets
 * until she goes broke or reach $goal. Keeps track of the number of
 * times she wins and the number of bets she makes. Run the experiment N
 * times, averages the results, and prints them out.
 * <p>
 * % java Gambler 50 250 1000
 * 178 wins of 1000
 * Percent of games won = 17.8
 * Avg # bets           = 10010.79
 * <p>
 * % java Gambler 50 150 1000
 * 337 wins of 1000
 * Percent of games won = 33.7
 * Avg # bets           = 4863.95
 * <p>
 * % java Gambler 50 100 1000
 * 503 wins of 1000
 * Percent of games won = 50.3
 * Avg # bets           = 2464.59
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"50", "250", "1000"})
@TestDrive({"50", "150", "1000"})
@TestDrive({"50", "100", "1000"})
public class Gambler {

  public static void main(final String[] args) {
    Executor.execute(Gambler.class, args);

    final var stake = Integer.parseInt(args[0]);
    final var goal = Integer.parseInt(args[1]);
    final var trials = Integer.parseInt(args[2]);

    var bets = 0;
    var wins = 0;

    for (var t = 0; t < trials; t++) {
      var cash = stake;
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

    System.out.println(wins + " wins of " + trials);
    System.out.println("Percent of games won = " + 100.0 * wins / trials);
    System.out.println("Avg # bets           = " + 1.0 * bets / trials);
  }
}
