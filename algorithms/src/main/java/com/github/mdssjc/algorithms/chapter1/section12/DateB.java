package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;

/**
 * Implementation B of Date.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "12", "31", "1999" })
public class DateB implements Date {

  private final int value;

  public DateB(final int m, final int d, final int y) {
    this.value = y * 512 + m * 32 + d;
  }

  @Override
  public int month() {
    return (this.value / 32) % 16;
  }

  @Override
  public int day() {
    return this.value % 32;
  }

  @Override
  public int year() {
    return this.value / 512;
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
