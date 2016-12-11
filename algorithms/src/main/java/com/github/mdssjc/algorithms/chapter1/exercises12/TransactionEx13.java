package com.github.mdssjc.algorithms.chapter1.exercises12;

import edu.princeton.cs.algs4.Date;

/**
 * TransactionEx13 Class.
 *
 * @author Marcelo dos Santos
 *
 */
class TransactionEx13 {

  private final String who;
  private final Date when;
  private final double amount;

  public TransactionEx13(final String who, final Date when, final double amount) {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  public TransactionEx13(final String transaction) {
    final String[] xs = transaction.split(",");
    this.who = xs[0];
    this.when = new Date(xs[1]);
    this.amount = Double.parseDouble(xs[2]);
  }

  public String who() {
    return this.who;
  }

  public Date when() {
    return this.when;
  }

  public double amount() {
    return this.amount;
  }

  @Override
  public String toString() {
    return String.format("%s: %s %.2f", this.who, this.when, this.amount);
  }
}
