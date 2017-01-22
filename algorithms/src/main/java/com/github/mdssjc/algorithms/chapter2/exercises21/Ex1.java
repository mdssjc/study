package com.github.mdssjc.algorithms.chapter2.exercises21;

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
@TestDrive("E A S Y Q U E S T I O N")
@TestDrive("S O R T E X A M P L E")
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final String[] a = args[0].split(" ");

    final String[] index = IntStream.range(0, a.length)
                                    .boxed()
                                    .map(String::valueOf)
                                    .toArray(String[]::new);

    StdOut.printf("%2s %3s  %s%n", "i", "min",
                  Arrays.deepToString(index));
    final SelectionSortEx1 selection = new SelectionSortEx1();

    selection.sort(a);
  }
}
