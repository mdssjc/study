package com.github.mdssjc.algorithms.chapter2.exercises23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.Monitor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("Q U I C K S O R T E X A M P L E")
@TestDrive("E A S Y Q U E S T I O N")
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final String[] a = args[0].split(" ");

    final Monitor monitor = new Monitor("m2", "lo", "j", "hi");
    final QuickSortMonitor quick = new QuickSortMonitor(monitor);
    quick.sort(a);
  }
}
