package com.github.mdssjc.algorithms.datastructure.queue.concrete;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * The {@code LinkedQueue} class represents a first-in-first-out (FIFO)
 * queue of generic items.
 * <p>
 * This implementation uses a singly-linked list with reference for
 * linked-list nodes.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *     the generic type of an item in this queue
 */
public class LinkedQueue<Item> implements Queue<Item> {

  private Node<Item> first;
  private Node<Item> last;
  private int size;

  @Override
  public void enqueue(final Item item) {
    final Node<Item> oldlast = this.last;

    this.last = new Node<>();
    this.last.item = item;
    this.last.next = null;

    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }

    this.size++;
  }

  @Override
  public Item dequeue() {
    final Item item = this.first.item;

    this.first = this.first.next;

    this.size--;

    if (isEmpty()) {
      this.last = null;
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<Item> iterator() {
    return new LinkedListIterator<>(this.first);
  }

  public static void main(final String[] args) {
    final Queue<String> q = new LinkedQueue<>();

    while (!StdIn.isEmpty()) {
      final String item = StdIn.readString();
      if (!item.equals("-")) {
        q.enqueue(item);
      } else if (!q.isEmpty()) {
        StdOut.print(q.dequeue() + "");
      }
      StdOut.println("(" + q.size() + " left on queue)");
    }
  }
}
