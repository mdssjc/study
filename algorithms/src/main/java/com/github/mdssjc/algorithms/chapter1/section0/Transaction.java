package com.github.mdssjc.algorithms.chapter1.section0;

/**
 * Transaction.
 * <p>
 * Compilation:  javac Transaction.java
 * Execution:    java Transaction
 * Dependencies: StdOut.java
 * <p>
 * Data type for commercial transactions.
 *
 * @author Marcelo dos Santos
 *
 */
import com.github.mdssjc.algorithms.introcs.chapter1.section16.Transition;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  The {@code Transaction} class is an immutable data type to encapsulate a
 *  commercial transaction with a customer name, date, and amount.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive
public class Transaction implements Comparable<Transaction> {

  private final String who;
  private final Date when;
  private final double amount;

  /**
   * Initializes a new transaction from the given arguments.
   *
   * @param  who the person involved in this transaction
   * @param  when the date of this transaction
   * @param  amount the amount of this transaction
   * @throws IllegalArgumentException if {@code amount}
   *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY},
   *         or {@code Double.NEGATIVE_INFINITY}
   */
  public Transaction(final String who, final Date when, final double amount) {
    if (Double.isNaN(amount) || Double.isInfinite(amount)) {
      throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  /**
   * Initializes a new transaction by parsing a string of the form NAME DATE AMOUNT.
   *
   * @param  transaction the string to parse
   * @throws IllegalArgumentException if {@code amount}
   *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY},
   *         or {@code Double.NEGATIVE_INFINITY}
   */
  public Transaction(final String transaction) {
    final var a = transaction.split("\\s+");
    this.who = a[0];
    this.when = new Date(a[1]);
    this.amount = Double.parseDouble(a[2]);
    if (Double.isNaN(this.amount) || Double.isInfinite(this.amount)) {
      throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }
  }

  /**
   * Returns the name of the customer involved in this transaction.
   *
   * @return the name of the customer involved in this transaction
   */
  public String who() {
    return this.who;
  }

  /**
   * Returns the date of this transaction.
   *
   * @return the date of this transaction
   */
  public Date when() {
    return this.when;
  }

  /**
   * Returns the amount of this transaction.
   *
   * @return the amount of this transaction
   */
  public double amount() {
    return this.amount;
  }

  /**
   * Returns a string representation of this transaction.
   *
   * @return a string representation of this transaction
   */
  @Override
  public String toString() {
    return String.format("%-10s %10s %8.2f", this.who, this.when, this.amount);
  }

  /**
   * Compares two transactions by amount.
   *
   * @param  that the other transaction
   * @return { a negative integer, zero, a positive integer}, depending
   *         on whether the amount of this transaction is { less than,
   *         equal to, or greater than } the amount of that transaction
   */
  @Override
  public int compareTo(final Transaction that) {
    return Double.compare(this.amount, that.amount);
  }

  /**
   * Compares this transaction to the specified object.
   *
   * @param  other the other transaction
   * @return true if this transaction is equal to {@code other}; false otherwise
   */
  @Override
  public boolean equals(final Object other) {
    if (other == this) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (other.getClass() != this.getClass()) {
      return false;
    }
    final var that = (Transaction) other;
    return (this.amount == that.amount) &&
           (this.who.equals(that.who)) &&
           (this.when.equals(that.when));
  }

  /**
   * Returns a hash code for this transaction.
   *
   * @return a hash code for this transaction
   */
  @Override
  public int hashCode() {
    var hash = 1;
    hash = 31 * hash + this.who.hashCode();
    hash = 31 * hash + this.when.hashCode();
    hash = 31 * hash + ((Double) this.amount).hashCode();
    return hash;
  }

  /**
   * Compares two transactions by customer name.
   */
  public static class WhoOrder implements Comparator<Transaction> {

    @Override
    public int compare(final Transaction v, final Transaction w) {
      return v.who.compareTo(w.who);
    }
  }

  /**
   * Compares two transactions by date.
   */
  public static class WhenOrder implements Comparator<Transaction> {

    @Override
    public int compare(final Transaction v, final Transaction w) {
      return v.when.compareTo(w.when);
    }
  }

  /**
   * Compares two transactions by amount.
   */
  public static class HowMuchOrder implements Comparator<Transaction> {

    @Override
    public int compare(final Transaction v, final Transaction w) {
      return Double.compare(v.amount, w.amount);
    }
  }

  /**
   * Unit tests the {@code Transaction} data type.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Transition.class, args);

    final var a = new Transaction[4];
    a[0] = new Transaction("Turing   6/17/1990  644.08");
    a[1] = new Transaction("Tarjan   3/26/2002 4121.85");
    a[2] = new Transaction("Knuth    6/14/1999  288.34");
    a[3] = new Transaction("Dijkstra 8/22/2007 2678.40");

    StdOut.println("Unsorted");
    for (var i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
    StdOut.println();

    StdOut.println("Sort by date");
    Arrays.sort(a, new Transaction.WhenOrder());
    for (var i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
    StdOut.println();

    StdOut.println("Sort by customer");
    Arrays.sort(a, new Transaction.WhoOrder());
    for (var i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
    StdOut.println();

    StdOut.println("Sort by amount");
    Arrays.sort(a, new Transaction.HowMuchOrder());
    for (var i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
    StdOut.println();
  }
}
