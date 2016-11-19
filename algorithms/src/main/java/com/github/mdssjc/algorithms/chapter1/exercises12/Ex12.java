package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.chapter1.section12.Datable;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 12.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"7", "10", "2016"} )
@TestDrive( {"8", "20", "2016"} )
@TestDrive( {"8", "28", "2016"} )
public class Ex12 implements Datable {

  private final int value;

  public Ex12(final int m, final int d, final int y) {
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

  // https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
  public String dayOfTheWeek() {
    final String[] daysWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"};
    final int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    int year = year();

    if (month() < 3) {
      year--;
    }

    year = year + year / 4 - year / 100 + year / 400;
    final int result = (year + t[month() - 1] + day()) % 7;

    return daysWeek[result];
  }

  @Override
  public String toString() {
    return month() + "/" + day() + "/" + year();
  }

  public static void main(final String[] args) {
    Executor.execute(Ex12.class, args);

    final int m = Integer.parseInt(args[0]);
    final int d = Integer.parseInt(args[1]);
    final int y = Integer.parseInt(args[2]);

    final Ex12 date = new Ex12(m, d, y);
    StdOut.println(date.dayOfTheWeek());
  }
}
