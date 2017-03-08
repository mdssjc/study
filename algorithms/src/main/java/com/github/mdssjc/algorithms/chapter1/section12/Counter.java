package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Counter data type.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Counter {

  private final String name;
  private int counter;

  public Counter(final String id) {
    this.name = id;
  }

  public static void main(final String[] args) {
    Executor.execute(Counter.class, args);

    final Counter heads = new Counter("heads");
    final Counter tails = new Counter("tails");

    heads.increment();
    heads.increment();
    tails.increment();

    StdOut.println(heads + " " + tails);
    StdOut.println(heads.tally() + tails.tally());
  }

  public void increment() {
    this.counter++;
  }

  public int tally() {
    return this.counter;
  }

  @Override
  public String toString() {
    return this.counter + " " + this.name;
  }
}
