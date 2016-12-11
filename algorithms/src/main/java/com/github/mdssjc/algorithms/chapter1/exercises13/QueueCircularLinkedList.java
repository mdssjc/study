package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;

import java.util.Iterator;

/**
 * QueueCircularLinkedList Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class QueueCircularLinkedList<T> implements Queue<T> {

  private Node<T> last = new Node<>();
  private int size;

  @Override
  public void enqueue(final T item) {
    final Node<T> oldlast = this.last;
    final Node<T> first = this.last.next;

    this.last = new Node<>();
    this.last.item = item;
    this.last.next = first;

    if (isEmpty()) {
      this.last.next = this.last;
    } else {
      oldlast.next = this.last;
    }

    this.size++;
  }

  @Override
  public T dequeue() {
    final T item = this.last.next.item;

    this.last.next = this.last.next.next;

    this.size--;

    if (isEmpty()) {
      this.last.next = this.last;
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator<>(this.last.next);
  }
}
