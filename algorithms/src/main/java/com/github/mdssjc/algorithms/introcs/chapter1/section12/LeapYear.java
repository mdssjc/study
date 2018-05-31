package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.2.4 Leap year.
 * <p>
 * Compilation:  javac LeapYear.java
 * Execution:    java LeapYear n
 * <p>
 * Prints true if n corresponds to a leap year, and false otherwise.
 * Assumes n >= 1582, corresponding to a year in the Gregorian calendar.
 * <p>
 * % java LeapYear 2004
 * true
 * <p>
 * % java LeapYear 1900
 * false
 * <p>
 * % java LeapYear 2000
 * true
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

    final var year = Integer.parseInt(args[0]);
    boolean isLeapYear;

    isLeapYear = (year % 4 == 0);
    isLeapYear = isLeapYear && (year % 100 != 0);
    isLeapYear = isLeapYear || (year % 400 == 0);

    System.out.println(isLeapYear);
  }
}
