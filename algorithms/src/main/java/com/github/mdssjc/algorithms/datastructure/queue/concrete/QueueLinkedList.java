package com.github.mdssjc.algorithms.datastructure.queue.concrete;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Implementação de FIFO Queue (Fila) com Linked List (Lista Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class QueueLinkedList<T> implements Queue<T> {

  protected Node<T> first;
  protected Node<T> last;
  private int     size;

  @Override
  public void enqueue(final T item) {
    final Node<T> oldlast = this.last;

    this.last = new Node<>();
    this.last.item = item;
    this.last.next = null;

    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }

    this.size++;
  }

  @Override
  public T dequeue() {
    final T item = this.first.item;

    this.first = this.first.next;

    this.size--;

    if (isEmpty()) {
      this.last = null;
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
    return new LinkedListIterator<>(this.first);
  }

  public static void main(final String[] args) {
    final Queue<String> q = new QueueLinkedList<>();

    while (!StdIn.isEmpty()) {
      final String item = StdIn.readString();
      if (!item.equals("-")) {
        q.enqueue(item);
      } else if (!q.isEmpty()) {
        StdOut.print(q.dequeue() + "");
      }
      StdOut.println("(" + q.size() + " left on queue)");
    }
  }
}
