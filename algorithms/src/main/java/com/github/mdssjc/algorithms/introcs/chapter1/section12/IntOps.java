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

  public static void main(String[] args) {
    Executor.execute(IntOps.class, args);

    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int p = a * b;
    int q = a / b;
    int r = a % b;
    System.out.println(a + " * " + b + " = " + p);
    System.out.println(a + " / " + b + " = " + q);
    System.out.println(a + " % " + b + " = " + r);
    System.out.println(a + " = " + q + " * " + b + " + " + r);
  }
}
