package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.3.6 Generic FIFO queue (linked list).
 *
 * @param <Item> Type parameter
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class Queue<Item> {

  private Node first;
  private Node last;
  private int size;

  public int size() {
    return this.size;
  }

  private class Node {

    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return (this.first == null);
  }

  public void enqueue(final Item item) {
    final Node oldLast = this.last;
    this.last = new Node();
    this.last.item = item;
    this.last.next = null;
    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldLast.next = this.last;
    }

    this.size++;
  }

  public Item dequeue() {
    final Item item = this.first.item;
    this.first = this.first.next;

    this.size--;

    if (isEmpty()) {
      this.last = null;
    }

    return item;
  }

  public static void main(final String[] args) {
    Executor.execute(Queue.class, args);

    final Queue<String> queue = new Queue<>();
    while (!StdIn.isEmpty()) {
      final String item = StdIn.readString();
      if (!item.equals("-")) {
        queue.enqueue(item);
      } else {
        StdOut.print(queue.dequeue() + " ");
      }
    }
  }
}
