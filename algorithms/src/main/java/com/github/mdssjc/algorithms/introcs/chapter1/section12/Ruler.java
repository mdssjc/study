package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.1 String concatenation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ruler {

  public static void main(final String[] args) {
    Executor.execute(Ruler.class, args);

    final String ruler1 = "1";
    final String ruler2 = ruler1 + " 2 " + ruler1;
    final String ruler3 = ruler2 + " 3 " + ruler2;
    final String ruler4 = ruler3 + " 4 " + ruler3;
    System.out.println(ruler1);
    System.out.println(ruler2);
    System.out.println(ruler3);
    System.out.println(ruler4);
  }
}
