package com.github.mdssjc.algorithms.datastructure.stack.concrete;

import java.util.Iterator;

import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.iterators.StackArrayIterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Implementação de Stack (Pilha) com capacidade fixa.
 * 
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class FixedCapacityStack<T> implements Stack<T> {

  private final T[] a;
  private int       n;

  public FixedCapacityStack(final int cap) {
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
    return new StackArrayIterator<>(this.a, this.n);
  }

  public static void main(final String[] args) {
    final FixedCapacityStack<String> s = new FixedCapacityStack<>(100);

    while (!StdIn.isEmpty()) {
      final String item = StdIn.readString();
      if (!item.equals("-")) {
        s.push(item);
      } else if (!s.isEmpty()) {
        StdOut.print(s.pop() + " ");
      }
    }

    StdOut.println("(" + s.size() + " left on stack)");
  }
}
