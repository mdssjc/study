package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.QueueLinkedList;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 21.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex21 {

  public static void main(final String[] args) {
    Executor.execute(Ex21.class, args);

    final Queue<String> list = new QueueLinkedList<>();
    list.enqueue("um");
    list.enqueue("dois");
    list.enqueue("três");

    String key = "dois";

    boolean result = find(list, key);

    StdOut.println(result);

    key = "quatro";

    result = find(list, key);
    assert !result;
    StdOut.println(result);
  }

  private static boolean find(final Queue<String> list, final String key) {
    for (final String value : list) {
      if (value.equals(key)) {
        return true;
      }
    }
    return false;
  }
}
