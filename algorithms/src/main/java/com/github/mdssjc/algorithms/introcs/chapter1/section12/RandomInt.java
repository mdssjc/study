package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.5 Casting to get a random integer.
 * <p>
 * Compilation:  javac RandomInt.java
 * Execution:    java RandomInt N
 * <p>
 * Prints a pseudo-random integer between 0 and N-1.
 * Illustrate an explicit type conversion (cast) from double to int.
 * <p>
 * % java RandomInt 6
 * Your random integer is: 5
 * <p>
 * % java RandomInt 6
 * Your random integer is: 0
 * <p>
 * % java RandomInt 1000
 * Your random integer is: 129
 * <p>
 * % java RandomInt 1000
 * Your random integer is: 333
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
