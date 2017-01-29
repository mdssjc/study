package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.Sort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.stream.IntStream;

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

    final String[] index = IntStream.range(0, a.length)
                                    .boxed()
                                    .map(String::valueOf)
                                    .toArray(String[]::new);

    StdOut.printf("%2s %2s %2s  %s%n", "k", "i", "j",
                  Arrays.deepToString(index));
    final Sort merge = new MergeSortMonitor(MergeSortMonitor.TYPE.TOP_DOWN,
                                            MergeSortMonitor.MONITOR.M1);

    merge.sort(a);
  }
}
