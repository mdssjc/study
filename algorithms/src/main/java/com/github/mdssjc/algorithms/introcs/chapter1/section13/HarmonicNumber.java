package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.5 Harmonic numbers.
 * <p>
 * Compilation:  javac HarmonicNumber.java
 * Execution:    java HarmonicNumber n
 * <p>
 * Prints the nth harmonic number: 1/1 + 1/2 + ... + 1/n.
 * <p>
 * % java HarmonicNumber 10
 * 2.9289682539682538
 * <p>
 * java HarmonicNumber 1000
 * 7.485470860550343
 * <p>
 * % java HarmonicNumber 10000
 * 9.787606036044348
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("10")
@TestDrive("1000")
@TestDrive("10000")
public class HarmonicNumber {

  public static void main(final String[] args) {
    Executor.execute(HarmonicNumber.class, args);

    final var n = Integer.parseInt(args[0]);

    var sum = 0.0;
    for (var i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }

    System.out.println(sum);
  }
}
