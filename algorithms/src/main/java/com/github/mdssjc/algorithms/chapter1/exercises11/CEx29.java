package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Creative Exercise 29.
 * <p>
 * Equal keys.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "1 2 3" )
public class CEx29 {

  public static void main(final String[] args) {
    Executor.execute(CEx29.class, args);

    final int[] whitelist = IntStream.generate(() -> ThreadLocalRandom.current()
                                                                      .nextInt(5))
                                     .limit(10)
                                     .sorted()
                                     .toArray();

    StdOut.println(Arrays.toString(whitelist));
    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      final int rank = BinarySearchCEx29.rank(key, whitelist);
      final int count = BinarySearchCEx29.count(key, whitelist);

      StdOut.println("Smaller than the key: " + rank);
      StdOut.println("Elements equal to the key: " + count);

      for (int i = rank; i < rank + count; i++) {
        StdOut.print(whitelist[i] + " ");
      }
      StdOut.println();
    }
  }
}
