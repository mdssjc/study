package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import java.util.stream.IntStream;

/**
 * Exercise 6.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex6 {

  private static final int LEN = 512;

  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);

    experiment(MergeSortMonitor.TYPE.TOP_DOWN);
    experiment(MergeSortMonitor.TYPE.BOTTOM_UP);
  }

  private static void experiment(final MergeSortMonitor.TYPE topDown) {
    final Integer[] values = IntStream.rangeClosed(1, LEN)
                                      .boxed()
                                      .toArray(Integer[]::new);

    final MergeSortMonitor merge = new MergeSortMonitor(topDown,
                                                        MergeSortMonitor.MONITOR.M4);
    merge.sort(values);
  }
}
