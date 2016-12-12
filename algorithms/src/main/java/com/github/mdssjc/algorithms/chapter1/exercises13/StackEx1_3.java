package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.ReverseArrayIterator;
import com.github.mdssjc.algorithms.datastructure.stack.Stack;

import java.util.Iterator;

/**
 * StackEx1_3 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class StackEx1_3<T> implements Stack<T> {

  private final T[] a;
  private int n;

  public StackEx1_3(final int cap) {
    this.a = (T[]) new Object[cap];
  }

  @Override
  public void push(final T item) {
    this.a[this.n++] = item;
  }

  @Override
  public T pop() {
    return this.a[--this.n];
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
  public Iterator<T> iterator() {
    return new ReverseArrayIterator<>(this.a, this.n);
  }

  public boolean isFull() {
    return this.n == this.a.length;
  }

  public T peek() {
    return this.a[this.n - 1];
  }
}
