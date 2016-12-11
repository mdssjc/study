package com.github.mdssjc.algorithms.chapter1.exercises12;

import edu.princeton.cs.algs4.Date;

/**
 * TransactionCEx19 Class.
 *
 * @author Marcelo dos Santos
 *
 */
class TransactionCEx19 {

  private final String who;
  private final Date when;
  private final double amount;

  public TransactionCEx19(final String who, final String date, final String amount) {
    this(who + "," + date + "," + amount);
  }

  public TransactionCEx19(final String transaction) {
    final String[] fields = transaction.split(",");

    this.who = fields[0];

    final String[] dates = fields[1].split("/");
    final int month = Integer.parseInt(dates[0]);
    final int day = Integer.parseInt(dates[1]);
    final int year = Integer.parseInt(dates[2]);
    this.when = new Date(month, day, year);

    this.amount = Double.parseDouble(fields[2]);
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
