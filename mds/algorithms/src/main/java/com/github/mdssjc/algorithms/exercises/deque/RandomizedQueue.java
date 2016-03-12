package com.github.mdssjc.algorithms.exercises.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Randomized Queue Data Type.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *          Data Type
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item[] queue;
  private int    head;
  private int    tail;

  private class IteratorImpl implements Iterator<Item> {

    private final Item[] queueCopy;
    private int          samples;

    // Iterator
    IteratorImpl(final Item[] queue, final int head, final int tail) {
      this.samples = tail - head;
      this.queueCopy = (Item[]) new Object[this.samples];

      for (int i = head; i < tail; i++) {
        this.queueCopy[i] = queue[i];
      }
      StdRandom.shuffle(this.queueCopy);
    }

    @Override
    public boolean hasNext() {
      return this.samples > 0;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No Such Element Exception");
      }

      return this.queueCopy[--this.samples];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException(
          "Unsupported Operation Exception");
    }
  }

  // construct an empty randomized queue
  public RandomizedQueue() {
    this.queue = (Item[]) new Object[2];
  }

  // is the queue empty?
  public boolean isEmpty() {
    return this.head == this.tail;
  }

  // return the number of items on the queue
  public int size() {
    return this.tail - this.head;
  }

  // resize queue
  private void resize(final int capacity) {
    final Item[] copy = (Item[]) new Object[capacity];

    for (int i = 0; i < size(); i++) {
      copy[i] = this.queue[i];
    }

    this.queue = copy;
  }

  // add the item
  public void enqueue(final Item item) {
    if (item == null) {
      throw new NullPointerException("Null Pointer Exception");
    }

    if (size() == this.queue.length) {
      resize(this.queue.length * 2);
    }

    this.queue[this.tail++] = item;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    final int cursor = StdRandom.uniform(this.head, this.tail);
    final Item item = this.queue[cursor];

    this.queue[cursor] = this.queue[this.tail - 1];
    this.queue[--this.tail] = null;

    if (size() > 0 && size() == this.queue.length / 4) {
      resize(this.queue.length / 2);
    }

    return item;
  }

  // return (but do not remove) a random item
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException("No Such Element Exception");
    }

    return this.queue[StdRandom.uniform(this.head, this.tail)];
  }

  // return an independent iterator over items in random order
  @Override
  public Iterator<Item> iterator() {
    return new IteratorImpl(this.queue, this.head, this.tail);
  }

  // unit testing
  public static void main(final String[] args) {
    final RandomizedQueue<String> rq = new RandomizedQueue<>();

    while (!StdIn.isEmpty()) {
      rq.enqueue(StdIn.readString());
    }

    StdOut.println(rq.size());
  }
}
