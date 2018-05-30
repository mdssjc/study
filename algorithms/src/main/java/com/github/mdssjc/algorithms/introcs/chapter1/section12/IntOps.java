package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.2 Integer multiplication and division.
 * <p>
 * Compilation:  javac IntOps.java
 * Execution:    java IntOps a b
 * <p>
 * Illustrates the integer operations a + b, a * b, a / b, and a % b.
 * <p>
 * % java IntOps 1234 99
 * 1234 + 99 = 1333
 * 1234 * 99 = 122166
 * 1234 / 99 = 12
 * 1234 % 99 = 46
 * 1234 = 12 * 99 + 46
 * <p>
 * % java IntOps 10 -3
 * 10 + -3 = 7
 * 10 * -3 = -30
 * 10 / -3 = -3
 * 10 % -3 = 1
 * 10 = -3 * -3 + 1
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"1234", "99"})
public class IntOps {

  public static void main(final String[] args) {
    Executor.execute(IntOps.class, args);

    final int a = Integer.parseInt(args[0]);
    final int b = Integer.parseInt(args[1]);
    final int sum = a + b;
    final int prod = a * b;
    final int quot = a / b;
    final int rem = a % b;

    System.out.println(a + " + " + b + " = " + sum);
    System.out.println(a + " * " + b + " = " + prod);
    System.out.println(a + " / " + b + " = " + quot);
    System.out.println(a + " % " + b + " = " + rem);
    System.out.println(a + " = " + quot + " * " + b + " + " + rem);
  }
}
