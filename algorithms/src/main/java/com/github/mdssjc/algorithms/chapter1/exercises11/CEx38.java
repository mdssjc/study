package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.chapter1.section11.BinarySearch;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Creative Exercise 38.
 * <p>
 * Binary search versus brute-force search.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"largeW.txt", "largeT.txt"}, valueFile = true)
public class CEx38 {

  public static void main(final String[] args) {
    Executor.execute(CEx38.class, args);

    final int[] whitelist = new In(args[0]).readAllInts();
    final int[] inputs = new In(args[1]).readAllInts();

    Arrays.sort(whitelist);

    StdOut.println("BinarySearch:");
    final Stopwatch stopwatchA = new Stopwatch();
    for (final int input : inputs) {
      if (BinarySearch.rank(input, whitelist) == -1) {
        StdOut.println(input);
      }
    }
    final double elapsedTimeA = stopwatchA.elapsedTime();

    StdOut.println("BruteForceSearch:");
    final Stopwatch stopwatchB = new Stopwatch();
    for (final int input : inputs) {
      if (BruteForceSearch.rank(input, whitelist) == -1) {
        StdOut.println(input);
      }
    }
    final double elapsedTimeB = stopwatchB.elapsedTime();

    StdOut.printf("Results:%nA: %.2f | B: %.2f%n", elapsedTimeA, elapsedTimeB);
  }
}
