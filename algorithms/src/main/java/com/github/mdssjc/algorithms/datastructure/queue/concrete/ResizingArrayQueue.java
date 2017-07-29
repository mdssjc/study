package com.github.mdssjc.algorithms.datastructure.queue.concrete;

import com.github.mdssjc.algorithms.datastructure.iterators.ArrayIterator;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * The {@code ResizingArrayQueue} class represents a first-in-first-out (FIFO)
 * queue of generic items.
 * <p>
 * This implementation uses a resizing array, which double the underlying array
 * when it is full and halves the underlying array when it is one-quarter full.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *     the generic type of an item in this queue
 */
public class ResizingArrayQueue<Item> implements Queue<Item> {

  private Item[] a;
  private int n;
  private int head;
  private int tail;

  public ResizingArrayQueue() {
    this.a = (Item[]) new Object[2];
  }

  private void resize(final int max) {
    final Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < this.n; i++) {
      temp[i] = this.a[(this.head + i) % this.a.length];
    }
    this.a = temp;
    this.head = 0;
    this.tail = this.n;
  }

  @Override
  public void enqueue(final Item item) {
    if (this.n == this.a.length) {
      resize(2 * this.a.length);
    }
    this.a[this.tail++] = item;
    if (this.tail == this.a.length) {
      this.tail = 0;
    }
    this.n++;
  }

  @Override
  public Item dequeue() {
    final Item item = this.a[this.head];
    this.a[this.head++] = null;
    this.n--;
    if (this.head == this.a.length) {
      this.head = 0;
    }
    if (this.n > 0 && this.n == this.a.length / 4) {
      resize(this.a.length / 2);
    }
    return item;
  }

  @Override
  public boolean isEmpty() {
    return this.n == 0;
  }

  @Override
  public int size() {
    return this.n;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayIterator<>(this.a, this.size());
  }

  public static void main(final String[] args) {
    final Queue<String> q = new ResizingArrayQueue<>();

    while (!StdIn.isEmpty()) {
      final String item = StdIn.readString();
      if (!item.equals("-")) {
        q.enqueue(item);
      } else if (!q.isEmpty()) {
        StdOut.print(q.dequeue() + " ");
      }
    }

    StdOut.println("(" + q.size() + " left on queue)");
  }
}
