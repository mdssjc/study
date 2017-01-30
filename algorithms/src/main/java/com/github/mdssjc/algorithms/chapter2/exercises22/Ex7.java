package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Exercise 7.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex7 {

  private static final int LEN = 10;

  public static void main(final String[] args) {
    Executor.execute(Ex7.class, args);

    final Integer[] values = ThreadLocalRandom.current()
                                              .ints()
                                              .limit(LEN)
                                              .boxed()
                                              .toArray(Integer[]::new);

    final MergeSortMonitor merge = new MergeSortMonitor(MergeSortMonitor.TYPE.TOP_DOWN,
                                                        MergeSortMonitor.MONITOR.M5);
    merge.sort(values);
  }
}
