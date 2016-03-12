package com.github.mdssjc.algorithms.exercises.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * Deque Data Type.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *          Data Type
 */
public class Deque<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int  size;

  // Node
  private class Node {

    private Item item;
    private Node next;
    private Node back;
  }

  // Iterator
  private final class IteratorImpl implements Iterator<Item> {

    private Deque<Item>.Node current;

    IteratorImpl(final Node current) {
      this.current = current;
    }

    @Override
    public boolean hasNext() {
      return this.current != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No Such Element Exception");
      }
      final Item item = this.current.item;
      this.current = this.current.next;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException(
          "Unsupported Operation Exception");
    }
  }

  // construct an empty deque
  public Deque() {
  }

  // is the deque empty?
  public boolean isEmpty() {
    return this.size == 0;
  }

  // return the number of items on the deque
  public int size() {
    return this.size;
  }

  // check null values
  private void checkNull(final Item item) {
    if (item == null) {
      throw new NullPointerException("Null Pointer Exception");
    }
  }

  // check empty
  private void checkEmpty() {
    if (isEmpty()) {
      throw new NoSuchElementException("No Such Element Exception");
    }
  }

  // add the item to the front
  public void addFirst(final Item item) {
    checkNull(item);

    final Node oldfirst = this.first;

    this.first = new Node();
    this.first.item = item;
    this.first.back = null;
    this.first.next = oldfirst;

    if (isEmpty()) {
      this.last = this.first;
    } else {
      oldfirst.back = this.first;
    }

    this.size++;
  }

  // add the item to the end
  public void addLast(final Item item) {
    checkNull(item);

    final Node oldlast = this.last;

    this.last = new Node();
    this.last.item = item;
    this.last.back = oldlast;
    this.last.next = null;

    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }

    this.size++;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    checkEmpty();

    final Item item = this.first.item;

    this.first = this.first.next;

    this.size--;
    if (isEmpty()) {
      this.last = this.first;
    } else {
      this.first.back = null;
    }

    return item;
  }

  // remove and return the item from the end
  public Item removeLast() {
    checkEmpty();

    final Item item = this.last.item;

    this.last = this.last.back;

    this.size--;
    if (isEmpty()) {
      this.first = this.last;
    } else {
      this.last.next = null;
    }

    return item;
  }

  // return an iterator over items in order from front to end
  @Override
  public Iterator<Item> iterator() {
    return new IteratorImpl(this.first);
  }

  // unit testing
  public static void main(final String[] args) {
    final Deque<Integer> deque = new Deque<Integer>();

    deque.addLast(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.removeFirst();
    deque.addFirst(5);
    deque.addLast(6);
    deque.removeLast();

    for (final int integer : deque) {
      StdOut.println(integer);
    }
  }
}
