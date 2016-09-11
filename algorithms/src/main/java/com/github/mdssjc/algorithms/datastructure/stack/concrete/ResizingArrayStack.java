package com.github.mdssjc.algorithms.datastructure.stack.concrete;

import java.util.Iterator;

import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.iterators.ReverseArrayIterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Implementação de Stack (Pilha) com capacidade redimensionável.
 * 
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class ResizingArrayStack<T> implements Stack<T> {

  private T[] a;
  private int n;

  public ResizingArrayStack() {
    this.a = (T[]) new Object[1];
  }

  @Override
  public void push(final T item) {
    if (this.n == this.a.length) {
      resize(2 * this.a.length);
    }
    this.a[this.n++] = item;
  }

  @Override
  public T pop() {
    final T item = this.a[--this.n];
    this.a[this.n] = null;
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
  public Iterator<T> iterator() {
    return new ReverseArrayIterator<>(this.a, this.n);
  }

  private void resize(final int max) {
    final T[] temp = (T[]) new Object[max];
    for (int i = 0; i < this.n; i++) {
      temp[i] = this.a[i];
    }
    this.a = temp;
  }

  public static void main(final String[] args) {
    final ResizingArrayStack<String> s = new ResizingArrayStack<>();

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
