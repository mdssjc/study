package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.2 Your first while loop.
 * <p>
 * Compilation:  javac TenHellos.java
 * Execution:    java TenHellos
 * <p>
 * Prints ith Hello for i = 1 to 10. Illlustrates using a while loop
 * for a repetitive task.
 * <p>
 * % java TenHellos
 * 1st Hello
 * 2nd Hello
 * 3rd Hello
 * 4th Hello
 * 5th Hello
 * 6th Hello
 * 7th Hello
 * 8th Hello
 * 9th Hello
 * 10th Hello
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class TenHellos {

  public static void main(final String[] args) {
    Executor.execute(TenHellos.class, args);

    System.out.println("1st Hello");
    System.out.println("2nd Hello");
    System.out.println("3rd Hello");

    var i = 4;
    while (i <= 10) {
      System.out.println(i + "th Hello");
      i++;
    }
  }
}
