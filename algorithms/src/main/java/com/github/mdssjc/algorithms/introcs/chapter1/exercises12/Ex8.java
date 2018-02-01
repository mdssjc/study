package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.introcs.chapter1.section12.Quadratic;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.8.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex8 {

  public static void main(final String[] args) {
    Executor.execute(Ex8.class, args);

    Quadratic.main(new String[]{"-3.0", "2.0"});
  }
}
