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
@TestDrive( input = "4 5 6" )
public class CEx28 {

  public static void main(final String[] args) {
    Executor.execute(CEx28.class, args);

    int[] whitelist = IntStream.generate(() -> ThreadLocalRandom.current()
                                                                .nextInt(5))
                               .limit(50)
                               .toArray();

    StdOut.println("Length: " + whitelist.length);
    whitelist = Arrays.stream(whitelist)
                      .sorted()
                      .distinct()
                      .toArray();
    StdOut.println("Length: " + whitelist.length);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (BinarySearchRecursive.rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }
}
