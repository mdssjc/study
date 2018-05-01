package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.3.1 Stack of strings (array).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "5", input = "tobe.txt", inputFile = true)
public class ArrayStackOfStrings {

  private final String[] items;
  private int n = 0;

  public ArrayStackOfStrings(final int capacity) {
    this.items = new String[capacity];
  }

  public boolean isEmpty() {
    return (this.n == 0);
  }

  public void push(final String item) {
    this.items[this.n++] = item;
  }

  public String pop() {
    return this.items[--this.n];
  }

  public static void main(final String[] args) {
    Executor.execute(ArrayStackOfStrings.class, args);

    final int cap = Integer.parseInt(args[0]);
    final ArrayStackOfStrings stack = new ArrayStackOfStrings(cap);
    while (!StdIn.isEmpty()) {
      final String item = StdIn.readString();
      if (!item.equals("-")) {
        stack.push(item);
      } else {
        StdOut.print(stack.pop() + " ");
      }
    }
  }
}
