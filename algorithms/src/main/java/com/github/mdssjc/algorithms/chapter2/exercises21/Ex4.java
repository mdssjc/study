package com.github.mdssjc.algorithms.chapter2.exercises21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Exercise 4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("E A S Y Q U E S T I O N")
@TestDrive("S O R T E X A M P L E")
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    final String[] a = args[0].split(" ");

    final String[] index = IntStream.range(0, a.length)
                                    .boxed()
                                    .map(String::valueOf)
                                    .toArray(String[]::new);

    StdOut.printf("%2s %2s  %s%n", "i", "j",
                  Arrays.deepToString(index));
    final InsertionSortEx4 insertion = new InsertionSortEx4();

    insertion.sort(a);
  }
}
