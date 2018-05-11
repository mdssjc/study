package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item> {

  private Item[] array;
  private int size;

  public RandomQueue() {
    this.size = 0;
    this.array = (Item[]) new Object[2];
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public void enqueue(final Item item) {
    if (this.size == this.array.length) {
      resize(2 * this.array.length);
    }

    this.array[this.size] = item;

    this.size++;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Stack underflow error");
    }

    final int rand = StdRandom.uniform(this.size);
    final Item item = this.array[rand];
    this.array[rand] = this.array[this.size - 1];
    this.array[this.size - 1] = null;

    this.size--;

    if (this.size > 0 && this.size == this.array.length / 4) {
      resize(this.size / 2);
    }

    return item;
  }

  public Item sample() {
    if (isEmpty()) {
      throw new RuntimeException("Stack underflow error");
    }

    return this.array[StdRandom.uniform(this.size)];
  }

  private void resize(final int max) {
    final Item[] temp = (Item[]) new Object[max];

    for (int i = 0; i < this.size; i++) {
      temp[i] = this.array[i];
    }

    this.array = temp;
  }

  @Override
  public Iterator<Item> iterator() {
    return new RandomQueueIterator();
  }

  private class RandomQueueIterator implements Iterator<Item> {

    private final Item[] iteratorArray;
    private int i;

    public RandomQueueIterator() {
      this.iteratorArray = RandomQueue.this.array.clone();
      this.i = RandomQueue.this.size;
    }

    @Override
    public boolean hasNext() {
      return this.i > 0;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      final int rand = StdRandom.uniform(this.i);
      final Item item = this.iteratorArray[rand];
      this.iteratorArray[rand] = this.iteratorArray[this.i - 1];
      this.iteratorArray[this.i - 1] = null;

      this.i--;

      return item;
    }
  }
}
