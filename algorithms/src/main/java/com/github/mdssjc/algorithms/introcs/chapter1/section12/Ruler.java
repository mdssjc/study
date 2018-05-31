package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.1 String concatenation.
 * <p>
 * Compilation:  javac Ruler.java
 * Execution:    java Ruler
 * <p>
 * Prints the relative lengths of the subdivisions on a ruler.
 * <p>
 * % java Ruler
 * 1
 * 1 2 1
 * 1 2 1 3 1 2 1
 * 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1
 * 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ruler {

  public static void main(final String[] args) {
    Executor.execute(Ruler.class, args);

    final var ruler1 = "1";
    final var ruler2 = ruler1 + " 2 " + ruler1;
    final var ruler3 = ruler2 + " 3 " + ruler2;
    final var ruler4 = ruler3 + " 4 " + ruler3;

    System.out.println(ruler1);
    System.out.println(ruler2);
    System.out.println(ruler3);
    System.out.println(ruler4);
  }
}
