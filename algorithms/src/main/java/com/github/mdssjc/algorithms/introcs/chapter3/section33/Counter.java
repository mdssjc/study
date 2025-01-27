package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 3.3.2 Counter.
 * <p>
 * Compilation:  javac Counter.java
 * Execution:    java Counter
 * Dependencies: StdRandom.java StdOut.java
 * <p>
 * % java Counter 6 600000
 * 0: 99870
 * 1: 99948
 * 2: 99738
 * 3: 100283
 * 4: 100185
 * 5: 99976
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"6", "600000"})
public class Counter implements Comparable<Counter> {

  private final String name;
  private final int maxCount;
  private int count;

  public Counter(final String id, final int max) {
    this.name = id;
    this.maxCount = max;
    this.count = 0;
  }

  public void increment() {
    if (this.count < this.maxCount) {
      this.count++;
    }
  }

  public int value() {
    return this.count;
  }

  @Override
  public String toString() {
    return this.name + ": " + this.count;
  }

  @Override
  public int compareTo(final Counter that) {
    if (this.count < that.count) {
      return -1;
    } else if (this.count > that.count) {
      return +1;
    } else {
      return 0;
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Counter.class, args);

    final int n = Integer.parseInt(args[0]);
    final int trials = Integer.parseInt(args[1]);

    final Counter[] hits = new Counter[n];
    for (int i = 0; i < n; i++) {
      hits[i] = new Counter(i + "", trials);
    }

    for (int t = 0; t < trials; t++) {
      final int index = StdRandom.uniform(n);
      hits[index].increment();
    }

    for (int i = 0; i < n; i++) {
      StdOut.println(hits[i]);
    }
  }
}
