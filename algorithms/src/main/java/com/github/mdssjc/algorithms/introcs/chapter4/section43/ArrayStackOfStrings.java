package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Program 4.3.1 Stack of strings (array).
 * <p>
 * Compilation:  javac ArrayStackOfStrings.java
 * Execution:    java ArrayStackOfStrings
 * Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
 * <p>
 * Stack of strings implementation with a fixed-size array.
 * <p>
 * % more tobe.txt
 * to be or not to - be - - that - - - is
 * <p>
 * % java ArrayStackOfStrings 5 < tobe.txt
 * to be not that or be
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "5", input = "tobe.txt", inputFile = true)
public class ArrayStackOfStrings {

  private final String[] items;
  private int n;

  public ArrayStackOfStrings(final int capacity) {
    this.items = new String[capacity];
  }

  public boolean isEmpty() {
    return this.n == 0;
  }

  public boolean isFull() {
    return this.n == this.items.length;
  }

  public void push(final String item) {
    this.items[this.n++] = item;
  }

  public String pop() {
    return this.items[--this.n];
  }

  public Iterator<String> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<String> {

    private int i = ArrayStackOfStrings.this.n - 1;

    @Override
    public boolean hasNext() {
      return this.i >= 0;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return ArrayStackOfStrings.this.items[this.i--];
    }
  }

  public static void main(final String[] args) {
    Executor.execute(ArrayStackOfStrings.class, args);

    final var capacity = Integer.parseInt(args[0]);
    final var stack = new ArrayStackOfStrings(capacity);
    while (!StdIn.isEmpty()) {
      final var item = StdIn.readString();
      if (!item.equals("-")) {
        stack.push(item);
      } else {
        StdOut.print(stack.pop() + " ");
      }
    }
    StdOut.println();
  }
}
