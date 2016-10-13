package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.FixedCapacityStack;

/**
 * Classe StackEx7.
 *
 * @author Marcelo dos Santos
 *
 */
public class StackEx7<T> extends FixedCapacityStack<T>{

  public StackEx7(final int cap) {
    super(cap);
  }

  public T peek() {
    return this.a[this.n - 1];
  }
}
