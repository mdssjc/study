package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 14 (Transaction).
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "Marcelo,08/28/2016,1520.55", "Marcelo,08/28/2016,1520.55" })
@TestDrive({ "Marcelos,08/28/2016,1520.55", "Marcelo,08/28/2016,1520.55" })
@TestDrive({ "Marcelo,08/27/2016,1520.55", "Marcelo,08/28/2016,1520.55" })
@TestDrive({ "Marcelo,08/28/2016,1520.56", "Marcelo,08/28/2016,1520.55" })
public class Ex14 {

  private final String who;
  private final Date   when;
  private final double amount;

  public Ex14(final String who, final Date when, final double amount) {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  public Ex14(final String transaction) {
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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(this.amount);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((this.when == null) ? 0 : this.when.hashCode());
    result = prime * result + ((this.who == null) ? 0 : this.who.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Ex14 other = (Ex14) obj;
    if (Double.doubleToLongBits(this.amount) != Double
      .doubleToLongBits(other.amount)) {
      return false;
    }
    if (this.when == null) {
      if (other.when != null) {
        return false;
      }
    } else if (!this.when.equals(other.when)) {
      return false;
    }
    if (this.who == null) {
      if (other.who != null) {
        return false;
      }
    } else if (!this.who.equals(other.who)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("%s: %s %.2f", this.who, this.when, this.amount);
  }

  public static void main(final String[] args) {
    Executor.execute(Ex14.class, args);

    final Ex14 log1 = new Ex14(args[0]);
    final Ex14 log2 = new Ex14(args[1]);

    StdOut.println(log1.equals(log2));
  }
}
