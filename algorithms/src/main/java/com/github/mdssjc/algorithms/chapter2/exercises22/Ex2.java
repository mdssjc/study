package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Exercise 2.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("M E R G E S O R T E X A M P L E")
@TestDrive("E A S Y Q U E S T I O N")
public class Ex2 {

  public static void main(final String[] args) {
    Executor.execute(Ex2.class, args);

    final String[] a = args[0].split(" ");

    final String[] index = IntStream.range(0, a.length)
                                    .boxed()
                                    .map(String::valueOf)
                                    .toArray(String[]::new);

    StdOut.printf("%2s %2s  %s%n", "i", "j",
                  Arrays.deepToString(index));
    final Sort merge = new MergeSortMonitor(MergeSortMonitor.TYPE.TOP_DOWN,
                                            MergeSortMonitor.MONITOR.M2);

    merge.sort(a);
  }
}
