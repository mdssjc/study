package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.ArrayIterator;
import com.github.mdssjc.algorithms.datastructure.queue.Queue;

import java.util.Iterator;

/**
 * Classe ResizingArrayQueueOfStrings.
 *
 * @author Marcelo dos Santos
 *
 */
public class ResizingArrayQueueOfStrings implements Queue<String> {

  private String[] a;
  private int head;
  private int tail;

  public ResizingArrayQueueOfStrings() {
    this.a = new String[1];
  }

  private void resize(final int max) {
    final String[] temp = new String[max];
    final int len = size();
    for (int i = 0; i < len; i++) {
      temp[i] = this.a[this.head++];
    }
    this.a = temp;
    this.head = 0;
    this.tail = len;
  }

  @Override
  public void enqueue(final String item) {
    if (this.tail == this.a.length) {
      resize(2 * this.a.length);
    }
    this.a[this.tail++] = item;
  }

  @Override
  public String dequeue() {
    final String item = this.a[this.head];
    this.a[this.head++] = null;
    if (this.head > 0 && size() == this.a.length / 4) {
      resize(this.a.length / 2);
    }
    return item;
  }

  @Override
  public boolean isEmpty() {
    return this.tail == this.head;
  }

  @Override
  public int size() {
    return this.tail - this.head;
  }

  @Override
  public Iterator<String> iterator() {
    return new ArrayIterator<>(this.a, this.size());
  }
}
