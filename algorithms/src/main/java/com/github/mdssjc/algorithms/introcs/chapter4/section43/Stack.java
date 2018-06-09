package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Program 4.3.4 Generic stack.
 * <p>
 * Compilation:  javac Stack.java
 * Execution:    java Stack < input.txt
 * Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
 * <p>
 * A generic stack, implemented using a linked list. Each stack
 * element is of type Item.
 * <p>
 * % more tobe.txt
 * to be or not to - be - - that - - - is
 * <p>
 * % java Stack < tobe.txt
 * to be not that or be (2 left on stack)
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, getting the number of
 *  items in the stack, and iterating over the items in LIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a nested class for
 *  linked-list nodes.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/43stack">Section 4.3</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this stack
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class Stack<Item> implements Iterable<Item> {

  private int n;
  private Node first;

  private class Node {

    private Item item;
    private Node next;
  }

  /**
   * Initializes an empty stack.
   */
  public Stack() {
    this.first = null;
    this.n = 0;
  }

  /**
   * Returns true if this stack is empty.
   *
   * @return true if this stack is empty; false otherwise
   */
  public boolean isEmpty() {
    return this.first == null;
  }

  /**
   * Returns the number of items in this stack.
   *
   * @return the number of items in this stack
   */
  public int size() {
    return this.n;
  }

  /**
   * Adds the item to this stack.
   *
   * @param  item the item to add
   */
  public void push(final Item item) {
    final var oldfirst = this.first;
    this.first = new Node();
    this.first.item = item;
    this.first.next = oldfirst;
    this.n++;
  }

  /**
   * Removes and returns the item most recently added to this stack.
   *
   * @return the item most recently added
   * @throws NoSuchElementException if this stack is empty
   */
  public Item pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    final var item = this.first.item;
    this.first = this.first.next;
    this.n--;
    return item;
  }

  /**
   * Returns (but does not remove) the item most recently added to this stack.
   *
   * @return the item most recently added to this stack
   * @throws NoSuchElementException if this stack is empty
   */
  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    return this.first.item;
  }

  /**
   * Returns a string representation of this stack.
   *
   * @return the sequence of items in this stack in LIFO order, separated by spaces
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
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order
   */
  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {

    private Node current = Stack.this.first;

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
   * Unit tests the {@code Stack} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(Stack.class, args);

    final var stack = new Stack<String>();
    while (!StdIn.isEmpty()) {
      final var item = StdIn.readString();
      if (!item.equals("-")) {
        stack.push(item);
      } else if (!stack.isEmpty()) {
        StdOut.print(stack.pop() + " ");
      }
    }
    StdOut.println("(" + stack.size() + " left on stack)");
  }
}
