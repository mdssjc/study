package com.github.mdssjc.algorithms.chapter1.section11;

import com.github.mdssjc.algorithms.search.BinarySearch;
import com.github.mdssjc.algorithms.search.concrete.BinarySearchRecursive;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Binary Search Recursive client.
 *
 * @author Marcelo dos Santos
 */
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
public class BinarySearchRecursiveClient {

  public static void main(final String[] args) {
    Executor.execute(BinarySearchRecursiveClient.class, args);

    final BinarySearch bs = new BinarySearchRecursive();
    final int[] whitelist = new In(args[0]).readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (bs.rank(key, whitelist) == -1) {
        StdOut.println(key);
      }
    }
  }
}
