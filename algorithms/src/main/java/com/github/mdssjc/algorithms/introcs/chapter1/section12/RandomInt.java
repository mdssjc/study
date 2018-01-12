package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.5 Casting to get a random integer.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("1000")
@TestDrive("1000")
@TestDrive("1000000")
public class RandomInt {

  public static void main(final String[] args) {
    Executor.execute(RandomInt.class, args);

    final int n = Integer.parseInt(args[0]);
    final double r = Math.random();
    final int value = (int) (r * n);
    System.out.println(value);
  }
}
