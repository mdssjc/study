package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Program 4.3.3 Stack of strings (resizing array).
 * <p>
 * Compilation:  javac ResizingArrayStackOfStrings.java
 * Execution:    java ResizingArrayStackOfStrings < input.txt
 * Dependencies: StdIn.java StdOut.java
 * Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
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
@TestDrive(input = "tobe.txt", inputFile = true)
public class ResizingArrayStackOfStrings {

  private String[] items;
  private int n = 0;

  public ResizingArrayStackOfStrings() {
    this.items = new String[2];
  }

  public boolean isEmpty() {
    return this.n == 0;
  }

  public int size() {
    return this.n;
  }

  private void resize(final int capacity) {
    assert capacity >= this.n;
    final var temp = new String[capacity];
    for (var i = 0; i < this.n; i++) {
      temp[i] = this.items[i];
    }
    this.items = temp;
  }

  public void push(final String item) {
    if (this.n == this.items.length) {
      resize(2 * this.items.length);
    }
    this.items[this.n++] = item;
  }

  public String pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }
    final var item = this.items[this.n - 1];
    this.items[this.n - 1] = null;
    this.n--;

    if (this.n > 0 && this.n == this.items.length / 4) {
      resize(
          this.items.length / 2);
    }
    return item;
  }

  public Iterator<String> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<String> {

    private int i = ResizingArrayStackOfStrings.this.n - 1;

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
      return ResizingArrayStackOfStrings.this.items[this.i--];
    }
  }

  public static void main(final String[] args) {
    Executor.execute(ResizingArrayStackOfStrings.class, args);

    final var stack = new ResizingArrayStackOfStrings();
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
