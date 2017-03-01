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
@TestDrive(input = "1 2 3")
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

      StdOut.println();
      StdOut.printf("Key is %d%n", key);
      StdOut.printf("Smaller than the key: %d%n", rank);
      StdOut.printf("Elements equal to the key: %d%n", count);

      // i = rank(key, a)
      // j = count(key, a)
      // a[i..i+j-1
      for (int i = rank; i < rank + count; i++) {
        StdOut.print(whitelist[i] + " ");
      }
      StdOut.println();
    }
  }
}
