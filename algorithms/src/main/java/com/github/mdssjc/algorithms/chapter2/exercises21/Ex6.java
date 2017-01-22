package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.sort.concrete.InsertionSort;
import com.github.mdssjc.algorithms.sort.concrete.SelectionSort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.stream.IntStream;

/**
 * Exercise 6.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex6 {
  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);

    final Integer[] a = IntStream.iterate(1, i -> 1)
                                 .limit(100000)
                                 .boxed()
                                 .toArray(Integer[]::new);

    Stopwatch timer = new Stopwatch();
    final SelectionSort selection = new SelectionSort();
    selection.sort(a);
    final double timeSelection = timer.elapsedTime();

    timer = new Stopwatch();
    final InsertionSort insertion = new InsertionSort();
    insertion.sort(a);
    final double timeInsertion = timer.elapsedTime();

    StdOut.printf("Selection: %.2fs | Insertion: %.2fs%n",
                  timeSelection, timeInsertion);
  }
}
