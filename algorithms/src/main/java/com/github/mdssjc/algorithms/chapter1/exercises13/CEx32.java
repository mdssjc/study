package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 32.
 * <p>
 * Steque.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx32 {

  public static void main(final String[] args) {
    Executor.execute(CEx32.class, args);

    final Steque<String> steque = new Steque<>();
    steque.push("um");
    final String poped = steque.pop();
    StdOut.println(poped);

    steque.enqueue("dois");
    steque.push("três");
    steque.enqueue("quatro");

    steque.iterator()
          .forEachRemaining(StdOut::println);
  }
}
