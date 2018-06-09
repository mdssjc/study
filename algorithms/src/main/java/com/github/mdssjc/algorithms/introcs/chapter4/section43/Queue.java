package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Program 4.3.6 Generic FIFO queue (linked list).
 * <p>
 * Compilation:  javac Queue.java
 * Execution:    java Queue < input.txt
 * Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
 * <p>
 * A generic queue, implemented using a linked list.
 * <p>
 * % java Queue < tobe.txt
 * to be or not to be (2 left on queue)
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code Queue} class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the top item,
 *  testing if the queue is empty, getting the number of items in the
 *  queue, and iterating over the items in FIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a nested class for
 *  linked-list nodes.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/43stack">Section 4.3</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this queue
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class Queue<Item> implements Iterable<Item> {

  private int n;
  private Node first;
  private Node last;

  private class Node {

    private Item item;
    private Node next;
  }

  /**
   * Initializes an empty queue.
   */
  public Queue() {
    this.first = null;
    this.last = null;
    this.n = 0;
  }

  /**
   * Returns true if this queue is empty.
   *
   * @return {@code true} if this queue is empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return this.first == null;
  }

  /**
   * Returns the number of items in this queue.
   *
   * @return the number of items in this queue
   */
  public int size() {
    return this.n;
  }

  /**
   * Returns the number of items in this queue.
   *
   * @return the number of items in this queue
   */
  public int length() {
    return this.n;
  }

  /**
   * Returns the item least recently added to this queue.
   *
   * @return the item least recently added to this queue
   * @throws NoSuchElementException if this queue is empty
   */
  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue underflow");
    }
    return this.first.item;
  }

  /**
   * Add the item to the queue.
   */
  public void enqueue(final Item item) {
    final var oldlast = this.last;
    this.last = new Node();
    this.last.item = item;
    this.last.next = null;
    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }
    this.n++;
  }

  /**
   * Removes and returns the item on this queue that was least recently added.
   *
   * @return the item on this queue that was least recently added
   * @throws NoSuchElementException if this queue is empty
   */
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue underflow");
    }
    final var item = this.first.item;
    this.first = this.first.next;
    this.n--;
    if (isEmpty()) {
      this.last = null;
    }
    return item;
  }

  /**
   * Returns a string representation of this queue.
   *
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    final var s = new StringBuilder();
    for (final var item : this) {
      s.append(item);
      s.append(' ');
    }
    return s.toString();
  }

  /**
   * Returns an iterator that iterates over the items in this queue in FIFO order.
   *
   * @return an iterator that iterates over the items in this queue in FIFO order
   */
  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {

    private Node current = Queue.this.first;

    @Override
    public boolean hasNext() {
      return this.current != null;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      final var item = this.current.item;
      this.current = this.current.next;
      return item;
    }
  }

  /**
   * Unit tests the {@code Queue} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(Queue.class, args);

    final var queue = new Queue<String>();
    while (!StdIn.isEmpty()) {
      final var item = StdIn.readString();
      if (!item.equals("-")) {
        queue.enqueue(item);
      } else if (!queue.isEmpty()) {
        StdOut.print(queue.dequeue() + " ");
      }
    }
    StdOut.println("(" + queue.size() + " left on queue)");
  }
}
