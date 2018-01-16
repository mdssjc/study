package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.3 Computing powers of 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("5")
@TestDrive("29")
public class PowersOfTwo {

  public static void main(final String[] args) {
    Executor.execute(PowersOfTwo.class, args);

    final int n = Integer.parseInt(args[0]);
    int power = 1;
    int i = 0;
    while (i <= n) {
      System.out.println(i + " " + power);
      power = 2 * power;
      i = i + 1;
    }
  }
}
