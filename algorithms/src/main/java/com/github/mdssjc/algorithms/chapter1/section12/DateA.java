package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;

/**
 * Implementation A of Date.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "12", "31", "1999" })
public class DateA implements Date {

  private final int month;
  private final int day;
  private final int year;

  public DateA(final int m, final int d, final int y) {
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
  public String toString() {
    return month() + "/" + day() + "/" + year();
  }

  public static void main(final String[] args) {
    final int m = Integer.parseInt(args[0]);
    final int d = Integer.parseInt(args[1]);
    final int y = Integer.parseInt(args[2]);
    final Date date = new DateA(m, d, y);
    StdOut.println(date);
  }
}
