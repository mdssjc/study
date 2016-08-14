package com.github.mdssjc.algorithms.chapter1.section12;

/**
 * Implementation B of Date.
 * 
 * @author Marcelo dos Santos
 *
 */
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
}
