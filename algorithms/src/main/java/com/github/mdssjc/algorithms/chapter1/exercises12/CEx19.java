package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 19.
 * <p>
 * Parsing.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"Marcelo", "08/28/2016", "1520.55"} )
@TestDrive( "Marcelo,08/28/2016,1520.55" )
public class CEx19 {

  public static void main(final String[] args) {
    Executor.execute(CEx19.class, args);

    final TransactionCEx19 transaction;
    if (args.length == 1) {
      transaction = new TransactionCEx19(args[0]);
    } else {
      transaction = new TransactionCEx19(args[0], args[1], args[2]);
    }

    StdOut.println(transaction);
  }
}

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
