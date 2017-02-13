package com.github.mdssjc.algorithms.chapter2.exercises23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.Monitor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 3.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("Q U I C K S O R T E X A M P L E")
public class Ex3 {

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    final String[] a = args[0].split(" ");

    final Monitor monitor = new Monitor("m3");
    final QuickSortMonitor quick = new QuickSortMonitor(monitor);
    quick.sort(a);
  }
}
