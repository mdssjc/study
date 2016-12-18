package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;

import java.util.Iterator;

/**
 * Steque Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Steque<T> {

  private Node<T> first;
  private Node<T> last;
  private int size;

  public void push(final T item) {
    final Node<T> oldfirst = this.first;

    this.first = new Node<>();
    this.first.item = item;
    this.first.next = oldfirst;

    if (this.size == 0) {
      this.last = this.first;
    }

    this.size++;
  }

  public T pop() {
    final T item = this.first.item;

    this.first = this.first.next;

    this.size--;

    if (this.size == 0) {
      this.first = null;
      this.last = null;
    }

    return item;
  }

  public void enqueue(final T item) {
    final Node<T> oldlast = this.last;

    this.last = new Node<>();
    this.last.item = item;
    this.last.next = null;

    if (this.size == 0) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }

    this.size++;
  }

  public Iterator<T> iterator() {
    return new LinkedListIterator<>(this.first);
  }
}
