package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Counter.
 * <p>
 * Compilation:  javac Counter.java
 * Execution:    java Counter n trials
 * Dependencies: StdRandom.java StdOut.java
 * <p>
 * A mutable data type for an integer counter.
 * <p>
 * The test clients create n counters and performs trials increment
 * operations on random counters.
 * <p>
 * java Counter 6 600000
 * 100140 counter0
 * 100273 counter1
 * 99848 counter2
 * 100129 counter3
 * 99973 counter4
 * 99637 counter5
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code Counter} class is a mutable data type to encapsulate a counter.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive({"6", "600000"})
public class Counter implements Comparable<Counter> {

  private final String name;
  private int count = 0;

  /**
   * Initializes a new counter starting at 0, with the given id.
   *
   * @param id the name of the counter
   */
  public Counter(final String id) {
    this.name = id;
  }

  /**
   * Increments the counter by 1.
   */
  public void increment() {
    this.count++;
  }

  /**
   * Returns the current value of this counter.
   *
   * @return the current value of this counter
   */
  public int tally() {
    return this.count;
  }

  /**
   * Returns a string representation of this counter.
   *
   * @return a string representation of this counter
   */
  @Override
  public String toString() {
    return this.count + " " + this.name;
  }

  /**
   * Compares this counter to the specified counter.
   *
   * @param  that the other counter
   * @return {@code 0} if the value of this counter equals
   *         the value of that counter; a negative integer if
   *         the value of this counter is less than the value of
   *         that counter; and a positive integer if the value
   *         of this counter is greater than the value of that
   *         counter
   */
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

  /**
   * Reads two command-line integers n and trials; creates n counters;
   * increments trials counters at random; and prints results.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Counter.class, args);

    final var n = Integer.parseInt(args[0]);
    final var trials = Integer.parseInt(args[1]);

    final var hits = new Counter[n];
    for (var i = 0; i < n; i++) {
      hits[i] = new Counter("counter" + i);
    }

    for (var t = 0; t < trials; t++) {
      hits[StdRandom.uniform(n)].increment();
    }

    for (var i = 0; i < n; i++) {
      StdOut.println(hits[i]);
    }
  }
}
