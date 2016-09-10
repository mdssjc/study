package com.github.mdssjc.algorithms.datastructure.stack.concrete;

import java.util.Iterator;

import com.github.mdssjc.algorithms.datastructure.stack.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Implementação de Stack (Pilha) com tamanho fixo.
 * 
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class FixedCapacityStack<T> implements Stack<T> {

  private final int cap;

  public FixedCapacityStack(final int cap) {
    this.cap = cap;
  }

  @Override
  public void push(final T item) {
  }

  @Override
  public T pop() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
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
