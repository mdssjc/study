package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.QueueLinkedList;

/**
 * Classe QueueEx20.
 *
 * @author Marcelo dos Santos
 *
 */
public class QueueEx20<T> extends QueueLinkedList<T> {

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
