package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LIFO stack (resizing array).
 * <p>
 * Compilation:  javac ResizingArrayStack.java
 * Execution:    java ResizingArrayStack < input.txt
 * Dependencies: StdIn.java StdOut.java
 * Data files:   https://algs4.cs.princeton.edu/13stacks/tobe.txt
 * <p>
 * Stack implementation with a resizing array.
 * <p>
 * % more tobe.txt
 * to be or not to - be - - that - - - is
 * <p>
 * % java ResizingArrayStack < tobe.txt
 * to be not that or be (2 left on stack)
 *
 * @author Marcelo dos Santos
 *
 */

/**
 * The {@code ResizingArrayStack} class represents a last-in-first-out (LIFO)
 * stack
 * of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with
 * methods
 * for peeking at the top item, testing if the stack is empty, and iterating
 * through
 * the items in LIFO order.
 * <p>
 * This implementation uses a resizing array, which double the underlying array
 * when it is full and halves the underlying array when it is one-quarter full.
 * The <em>push</em> and <em>pop</em> operations take constant amortized time.
 * The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 * constant time in the worst case.
 * <p>
 * For additional documentation,
 * see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class ResizingArrayStack<Item> implements Iterable<Item> {

  private Item[] a;
  private int n;

  /**
   * Initializes an empty stack.
   */
  public ResizingArrayStack() {
    this.a = (Item[]) new Object[2];
    this.n = 0;
  }

  /**
   * Is this stack empty?
   *
   * @return true if this stack is empty; false otherwise
   */
  public boolean isEmpty() {
    return this.n == 0;
  }

  /**
   * Returns the number of items in the stack.
   *
   * @return the number of items in the stack
   */
  public int size() {
    return this.n;
  }

  private void resize(final int capacity) {
    assert capacity >= this.n;

    final var temp = (Item[]) new Object[capacity];
    for (var i = 0; i < this.n; i++) {
      temp[i] = this.a[i];
    }
    this.a = temp;
  }

  /**
   * Adds the item to this stack.
   *
   * @param item
   *     the item to add
   */
  public void push(final Item item) {
    if (this.n == this.a.length) {
      resize(2 * this.a.length);
    }
    this.a[this.n++] = item;
  }

  /**
   * Removes and returns the item most recently added to this stack.
   *
   * @return the item most recently added
   *
   * @throws java.util.NoSuchElementException
   *     if this stack is empty
   */
  public Item pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    final var item = this.a[this.n - 1];
    this.a[this.n - 1] = null;
    this.n--;
    if (this.n > 0 && this.n == this.a.length / 4) {
      resize(this.a.length / 2);
    }
    return item;
  }

  /**
   * Returns (but does not remove) the item most recently added to this stack.
   *
   * @return the item most recently added to this stack
   *
   * @throws java.util.NoSuchElementException
   *     if this stack is empty
   */
  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    return this.a[this.n - 1];
  }

  /**
   * Returns an iterator to this stack that iterates through the items in LIFO
   * order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order.
   */
  @Override
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {

    private int i;

    public ReverseArrayIterator() {
      this.i = ResizingArrayStack.this.n - 1;
    }

    @Override
    public boolean hasNext() {
      return this.i >= 0;
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
      return ResizingArrayStack.this.a[this.i--];
    }
  }

  /**
   * Unit tests the {@code Stack} data type.
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(ResizingArrayStack.class, args);

    final var stack = new ResizingArrayStack<String>();
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
