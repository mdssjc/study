package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.Monitor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("E E G M R A C E R T")
@TestDrive("A E Q S U Y E I N O S T")
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final String[] a = args[0].split(" ");

    final Monitor monitor = new Monitor("m1", "k", "i", "j");
    final Sort merge = new MergeSortMonitor(MergeSortMonitor.TYPE.TOP_DOWN, monitor);
    merge.sort(a);
  }
}
