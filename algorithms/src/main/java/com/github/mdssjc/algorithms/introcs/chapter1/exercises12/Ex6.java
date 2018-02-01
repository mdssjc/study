package com.github.mdssjc.algorithms.introcs.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.2.6.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex6 {

  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);

    System.out.println(10 / 3);
    System.out.println("Since both 10 and 3 are integer literals, Java sees " +
                       "no need for type conversion and uses integer division." +
                       " You should write 10.0/3.0 if you mean the numbers to " +
                       "be double literals. If you write 10/3.0 or 10.0/3, " +
                       "Java does implicit conversion to get the same result.");
  }
}
