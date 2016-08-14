package com.github.mdssjc.algorithms.chapter1.section12;

/**
 * Implementation A of Date.
 * 
 * @author Marcelo dos Santos
 *
 */
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
}
