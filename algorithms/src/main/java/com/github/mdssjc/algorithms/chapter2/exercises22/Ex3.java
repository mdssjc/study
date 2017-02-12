package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.Monitor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 3.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("M E R G E S O R T E X A M P L E")
@TestDrive("E A S Y Q U E S T I O N")
public class Ex3 {

  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    final String[] a = args[0].split(" ");

    final Monitor monitor = new Monitor(Monitor.MONITOR.M3);
    final Sort merge = new MergeSortMonitor(MergeSortMonitor.TYPE.BOTTOM_UP, monitor);
    merge.sort(a);
  }
}
