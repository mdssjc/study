package com.github.mdssjc.algorithms.chapter2.section21;

import com.github.mdssjc.algorithms.chapter1.section12.Datable;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Date Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"12", "31", "1999"} )
public class Date implements Datable, Comparable<Date> {

  private final int month;
  private final int day;
  private final int year;

  public Date(final int m, final int d, final int y) {
    this.month = m;
    this.day = d;
    this.year = y;
  }

  @Override
  public int month() {
    return this.month;
  }

  @Override
  public int day() {
    return this.day;
  }

  @Override
  public int year() {
    return this.year;
  }

  @Override
  public int compareTo(final Date that) {
    if (this.year > that.year) {
      return +1;
    }
    if (this.year < that.year) {
      return -1;
    }
    if (this.month > that.month) {
      return +1;
    }
    if (this.month < that.month) {
      return -1;
    }
    if (this.day > that.day) {
      return +1;
    }
    if (this.day < that.day) {
      return -1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return month() + "/" + day() + "/" + year();
  }

  @Override
  public boolean equals(final Object x) {
    if (this == x) {
      return true;
    }
    if (x == null) {
      return false;
    }
    if (this.getClass() != x.getClass()) {
      return false;
    }
    final Datable that = (Datable) x;
    if (this.day != that.day()) {
      return false;
    }
    if (this.month != that.month()) {
      return false;
    }
    if (this.year != that.year()) {
      return false;
    }
    return true;
  }

  public static void main(final String[] args) {
    Executor.execute(Date.class, args);

    final int m = Integer.parseInt(args[0]);
    final int d = Integer.parseInt(args[1]);
    final int y = Integer.parseInt(args[2]);
    final Datable date = new Date(m, d, y);
    StdOut.println(date);
  }
}
