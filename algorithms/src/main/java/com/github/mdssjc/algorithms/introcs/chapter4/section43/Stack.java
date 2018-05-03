package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.3.4 Generic stack.
 *
 * @param <Item> Type parameter
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class Stack<Item> {

  private Node first;

  private class Node {

    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return (this.first == null);
  }

  public void push(final Item item) {
    final Node oldFirst = this.first;
    this.first = new Node();
    this.first.item = item;
    this.first.next = oldFirst;
  }

  public Item pop() {
    final Item item = this.first.item;
    this.first = this.first.next;
    return item;
  }

  public static void main(final String[] args) {
    Executor.execute(Stack.class, args);

    final Stack<String> stack = new Stack<>();
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
