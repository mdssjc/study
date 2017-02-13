package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.Monitor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Exercise 8.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex8 {

  private static final int LEN = 10;

  public static void main(final String[] args) {
    Executor.execute(Ex8.class, args);

    final Integer[] values = ThreadLocalRandom.current()
                                              .ints()
                                              .limit(LEN)
                                              .boxed()
                                              .toArray(Integer[]::new);

    final Monitor monitor = new Monitor("m6");
    final MergeSortMonitor merge = new MergeSortMonitor(MergeSortMonitor.TYPE.TOP_DOWN, monitor);
    merge.sort(values);
  }
}
