package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Binary search.
 * <p>
 * Compilation:  javac BinarySearch.java
 * Execution:    java BinarySearch whitelist.txt < input.txt
 * Dependencies: In.java StdIn.java StdOut.java
 * Data files:   https://algs4.cs.princeton.edu/11model/tinyW.txt
 *               https://algs4.cs.princeton.edu/11model/tinyT.txt
 *               https://algs4.cs.princeton.edu/11model/largeW.txt
 *               https://algs4.cs.princeton.edu/11model/largeT.txt
 * <p>
 * % java BinarySearch tinyW.txt < tinyT.txt
 * 50
 * 99
 * 13
 * <p>
 * % java BinarySearch largeW.txt < largeT.txt | more
 * 499569
 * 984875
 * 295754
 * 207807
 * 140925
 * 161828
 * [367,966 total values]
 *
 * @author Marcelo dos Santos
 *
 */

/**
 * The {@code BinarySearch} class provides a static method for binary
 * searching for an integer in a sorted array of integers.
 * <p>
 * The <em>indexOf</em> operations takes logarithmic time in the worst case.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section
 * 1.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
@TestDrive(value = "tinyW.txt", valueFile = true, input = "tinyT.txt", inputFile = true)
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
public class BinarySearch {

  /**
   * This class should not be instantiated.
   */
  private BinarySearch() {
  }

  /**
   * Returns the index of the specified key in the specified array.
   *
   * @param a
   *     the array of integers, must be sorted in ascending order
   * @param key
   *     the search key
   *
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   */
  public static int indexOf(final int[] a, final int key) {
    var lo = 0;
    var hi = a.length - 1;
    while (lo <= hi) {
      final var mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the specified key in the specified array.
   * This function is poorly named because it does not give the <em>rank</em>
   * if the array has duplicate keys or if the key is not in the array.
   *
   * @param key
   *     the search key
   * @param a
   *     the array of integers, must be sorted in ascending order
   *
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   *
   * @deprecated Replaced by {@link #indexOf(int[], int)}.
   */
  @Deprecated
  public static int rank(final int key, final int[] a) {
    return indexOf(a, key);
  }

  /**
   * Reads in a sequence of integers from the whitelist file, specified as
   * a command-line argument; reads in integers from standard input;
   * prints to standard output those integers that do <em>not</em> appear in the
   * file.
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(BinarySearch.class, args);

    final var in = new In(args[0]);
    final var whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      final var key = StdIn.readInt();
      if (BinarySearch.indexOf(whitelist, key) == -1) {
        StdOut.println(key);
      }
    }
  }
}
