package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.QueueLinkedList;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 20.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "0" )
@TestDrive( "1" )
@TestDrive( "2" )
@TestDrive( "3" )
@TestDrive( "4" )
public class Ex20 {

  public static void main(final String[] args) {
    Executor.execute(Ex20.class, args);

    final QueueEx20<String> queue = new QueueEx20<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    queue.delete(Integer.parseInt(args[0]));

    for (final String s : queue) {
      StdOut.print(queue.dequeue() + " ");
    }
    StdOut.println();
  }
}

class QueueEx20<T> extends QueueLinkedList<T> {

  public void delete(final int k) {
    if (k <= 0 || k > size()) {
      return;
    }

    if (k == 1) {
      this.first = this.first.next;
      return;
    }

    Node tmp = this.first;
    for (int i = 2; i < k; i++) {
      tmp = tmp.next;
    }

    if (tmp == this.last) {
      this.last = null;
    } else {
      tmp.next = tmp.next.next;
    }
  }
}
