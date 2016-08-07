package com.github.mdssjc.algorithms.chapter1.section12;

import edu.princeton.cs.algs4.StdOut;

/**
 * Counter Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Counter {

  private final String id;
  private int          counter;

  public Counter(final String id) {
    this.id = id;
  }

  public void increment() {
    this.counter++;
  }

  public int tally() {
    return this.counter;
  }

  @Override
  public String toString() {
    return this.counter + " " + this.id;
  }

  public static void main(final String[] args) {
    final Counter heads = new Counter("heads");
    final Counter tails = new Counter("tails");

    heads.increment();
    final int result = heads.tally() - tails.tally();
    StdOut.println(heads);
  }
}
