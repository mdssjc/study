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

    // Deque
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

    // Resizing Array Deque
    final ResizingArrayDeque<String> dequeRA = new ResizingArrayDeque<>();
    assert dequeRA.isEmpty();
    assert dequeRA.size() == 0;
    dequeRA.pushLeft("um");
    dequeRA.pushLeft("dois");
    dequeRA.pushRight("três");
    dequeRA.pushRight("quatro");
    assert dequeRA.popLeft()
                  .equals("dois");
    assert dequeRA.popRight()
                  .equals("quatro");

    dequeRA.iterator()
           .forEachRemaining(StdOut::println);
  }
}
