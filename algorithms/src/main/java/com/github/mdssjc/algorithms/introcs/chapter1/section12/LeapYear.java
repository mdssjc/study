package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.4 Leap year.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("2004")
@TestDrive("1900")
@TestDrive("2000")
public class LeapYear {

  public static void main(final String[] args) {
    Executor.execute(LeapYear.class, args);

    final int year = Integer.parseInt(args[0]);
    boolean isLeapYear;
    isLeapYear = (year % 4 == 0);
    isLeapYear = isLeapYear && (year % 100 != 0);
    isLeapYear = isLeapYear || (year % 400 == 0);
    System.out.println(isLeapYear);
  }
}
