package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.FixedCapacityStack;

/**
 * StackEx1 Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class StackEx1<T> extends FixedCapacityStack<T> {

  public StackEx1(final int cap) {
    super(cap);
  }

  public boolean isFull() {
    return this.n == this.a.length;
  }
}
