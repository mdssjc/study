package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.NoSuchElementException;

/**
 * Program 4.3.2 Stack of strings (linked list).
 * <p>
 * Compilation:  javac LinkedStackOfStrings.java
 * Execution:    java LinkedStackOfStrings
 * Data files:   https://introcs.cs.princeton.edu/43stack/tobe.txt
 * <p>
 * A stack of strings, implemented using a linked list.
 * <p>
 * % more tobe.txt
 * to be or not to - be - - that - - - is
 * <p>
 * % java LinkedStackOfStrings < tobe.txt
 * to be not that or be
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class LinkedStackOfStrings {

  private int n;
  private Node first;

  private class Node {

    private String item;
    private Node next;
  }

  public boolean isEmpty() {
    return this.first == null;
  }

  public int size() {
    return this.n;
  }

  public void push(final String item) {
    final var oldfirst = this.first;
    this.first = new Node();
    this.first.item = item;
    this.first.next = oldfirst;
    this.n++;
  }

  public String pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("stack underflow");
    }
    final var item = this.first.item;
    this.first = this.first.next;
    this.n--;
    return item;
  }

  public static void main(final String[] args) {
    Executor.execute(LinkedStackOfStrings.class, args);

    final var stack = new LinkedStackOfStrings();
    while (!StdIn.isEmpty()) {
      final var item = StdIn.readString();
      if (!item.equals("-")) {
        stack.push(item);
      } else if (stack.isEmpty()) {
        StdOut.println("BAD INPUT");
      } else {
        StdOut.print(stack.pop() + " ");
      }
    }
  }
}
