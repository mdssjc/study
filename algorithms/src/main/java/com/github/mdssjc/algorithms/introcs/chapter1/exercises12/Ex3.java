package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.3.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex3 {

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    boolean a;
    boolean b;

    a = false;
    b = false;
    final boolean result1 = (!(a && b) && (a || b)) || ((a && b) || !(a || b));

    a = false;
    b = true;
    final boolean result2 = (!(a && b) && (a || b)) || ((a && b) || !(a || b));

    a = true;
    b = false;
    final boolean result3 = (!(a && b) && (a || b)) || ((a && b) || !(a || b));

    a = true;
    b = true;
    final boolean result4 = (!(a && b) && (a || b)) || ((a && b) || !(a || b));

    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
    System.out.println(result4);
  }
}
