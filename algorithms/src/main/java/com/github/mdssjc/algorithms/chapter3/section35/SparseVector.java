package com.github.mdssjc.algorithms.chapter3.section35;

import edu.princeton.cs.algs4.LinearProbingHashST;

/**
 * SparseVector Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class SparseVector {

  private final LinearProbingHashST<Integer, Double> st;

  public SparseVector() {
    this.st = new LinearProbingHashST<>();
  }

  public int size() {
    return this.st.size();
  }

  public void put(final int i, final double x) {
    this.st.put(i, x);
  }

  public double get(final int i) {
    if (!this.st.contains(i)) {
      return 0.0;
    } else {
      return this.st.get(i);
    }
  }

  public double dot(final double[] that) {
    double sum = 0.0;
    for (final int i : this.st.keys()) {
      sum += that[i] * this.get(i);
    }
    return sum;
  }
}
