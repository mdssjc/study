package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 13.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"Marcelo", "08/28/2016", "1520.55"} )
@TestDrive( "Marcelo,08/28/2016,1520.55" )
public class Ex13 {

  public static void main(final String[] args) {
    Executor.execute(Ex13.class, args);

    final TransactionEx13 transaction;
    if (args.length == 1) {
      transaction = new TransactionEx13(args[0]);
    } else {
      final String who = args[0];
      final Date when = new Date(args[1]);
      final double amount = Double.parseDouble(args[2]);
      transaction = new TransactionEx13(who, when, amount);
    }

    StdOut.println(transaction);
  }
}

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
