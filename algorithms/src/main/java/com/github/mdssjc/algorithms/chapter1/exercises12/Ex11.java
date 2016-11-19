package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.chapter1.section12.Datable;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 11.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"0", "31", "1999"} )
@TestDrive( {"12", "0", "1999"} )
@TestDrive( {"12", "31", "0"} )
public class Ex11 implements Datable {

  private final int value;

  public Ex11(final int m, final int d, final int y) {
    if (m < 1 || m > 12) {
      throw new RuntimeException("Date is not legal: month.");
    }
    if (d < 1 || d > 31) {
      throw new RuntimeException("Date is not legal: day.");
    }
    if (y < 1) {
      throw new RuntimeException("Date is not legal: year.");
    }

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
    Executor.execute(Ex11.class, args);

    final int m = Integer.parseInt(args[0]);
    final int d = Integer.parseInt(args[1]);
    final int y = Integer.parseInt(args[2]);

    try {
      final Datable date = new Ex11(m, d, y);
    } catch (final Exception e) {
      StdOut.println(e.getMessage());
    }
  }
}
