package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 33.
 * <p>
 * Deque.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx33 {

  public static void main(final String[] args) {
    Executor.execute(CEx33.class, args);

    final Deque<String> deque = new Deque<>();
    assert deque.isEmpty();
    assert deque.size() == 0;
    deque.pushLeft("um");
    deque.pushLeft("dois");
    deque.pushRight("três");
    deque.pushRight("quatro");
    assert deque.popLeft()
                .equals("dois");
    assert deque.popRight()
                .equals("quatro");

    deque.iterator()
         .forEachRemaining(StdOut::println);
  }
}
