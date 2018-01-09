package com.github.mdssjc.algorithms.introcs.chapter1.section12;


import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.2 Integer multiplication and division.
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
    final int p = a * b;
    final int q = a / b;
    final int r = a % b;
    System.out.println(a + " * " + b + " = " + p);
    System.out.println(a + " / " + b + " = " + q);
    System.out.println(a + " % " + b + " = " + r);
    System.out.println(a + " = " + q + " * " + b + " + " + r);
  }
}
