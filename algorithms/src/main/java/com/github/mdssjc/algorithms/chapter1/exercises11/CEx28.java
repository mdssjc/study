package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.chapter1.section11.BinarySearchRecursive;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Creative Exercise 28.
 * <p>
 * Remove duplicates.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "4 5 6")
public class CEx28 {

  public static void main(final String[] args) {
    Executor.execute(CEx28.class, args);

    int[] whitelist = IntStream.generate(() -> ThreadLocalRandom.current()
                                                                .nextInt(5))
                               .limit(50)
                               .sorted()
                               .toArray();

    int[] temp = null;
    for (final int key : whitelist) {
      if (temp == null) {
        temp = new int[]{key};
      } else if (BinarySearchRecursive.rank(key, temp) == -1) {
        temp = Arrays.copyOf(temp, temp.length + 1);
        temp[temp.length - 1] = key;
      }
    }
    StdOut.printf("From %s%nto %s%n", Arrays.toString(whitelist), Arrays.toString(temp));
    whitelist = temp;

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (BinarySearchRecursive.rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }
}
