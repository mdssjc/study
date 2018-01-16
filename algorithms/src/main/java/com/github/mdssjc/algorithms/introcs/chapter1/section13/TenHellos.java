package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.2 Your first while loop.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TenHellos {

  public static void main(final String[] args) {
    Executor.execute(TenHellos.class,args);

    System.out.println("1st Hello");
    System.out.println("2nd Hello");
    System.out.println("3rd Hello");
    int i = 4;
    while (i <= 10) {
      System.out.println(i + "th Hello");
      i = i + 1;
    }
  }
}
