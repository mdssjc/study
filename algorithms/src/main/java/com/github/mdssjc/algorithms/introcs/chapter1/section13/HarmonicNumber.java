package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.5 Harmonic numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("2")
@TestDrive("10")
@TestDrive("10000")
@TestDrive("1000000")
public class HarmonicNumber {

  public static void main(final String[] args) {
    Executor.execute(HarmonicNumber.class, args);

    final int n = Integer.parseInt(args[0]);
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    System.out.println(sum);
  }
}
