package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.3.3 Stack of strings (resizing array).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class ResizingArrayStackOfStrings {

  private String[] items = new String[1];
  private int n = 0;


  public boolean isEmpty() {
    return (this.n == 0);
  }

  private void resize(final int capacity) {
    final String[] temp = new String[capacity];
    for (int i = 0; i < this.n; i++) {
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
    final String item = this.items[--this.n];
    this.items[this.n] = null;
    if (this.n > 0 && this.n == this.items.length / 4) {
      resize(this.items.length / 2);
    }
    return item;
  }

  public static void main(final String[] args) {
    Executor.execute(LinkedStackOfStrings.class, args);

    final ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
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
