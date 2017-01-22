package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.sort.concrete.SelectionSort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdArrayIO;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Exercise 3.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex3 {
  public static void main(final String[] args) {
    Executor.execute(Ex3.class, args);

    final Integer[] a = IntStream.rangeClosed(0, 5)
                                 .boxed()
                                 .sorted(Collections.reverseOrder())
                                 .toArray(Integer[]::new);

    final SelectionSort selection = new SelectionSort();
    selection.sort(a);

    StdArrayIO.print(Arrays.stream(a)
                           .mapToInt(Integer::intValue)
                           .toArray());
  }
}
