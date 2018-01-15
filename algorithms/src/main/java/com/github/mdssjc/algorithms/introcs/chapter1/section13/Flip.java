package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.1 Flipping a fair coin.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
@TestDrive
@TestDrive
public class Flip {

  public static void main(final String[] args) {
    Executor.execute(Flip.class, args);

    if (Math.random() < 0.5) {
      System.out.println("Heads");
    } else {
      System.out.println("Tails");
    }
  }
}
