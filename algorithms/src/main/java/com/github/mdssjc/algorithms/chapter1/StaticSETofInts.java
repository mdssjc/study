package com.github.mdssjc.algorithms.chapter1;

import java.util.Arrays;

/**
 * Set of integers.
 * <p>
 * Compilation:  javac StaticSetOfInts.java
 * Execution:    none
 * Dependencies: StdOut.java
 * <p>
 * Data type to store a set of integers.
 *
 * @author Marcelo dos Santos
 *
 */

/**
 * The {@code StaticSETofInts} class represents a set of integers.
 * It supports searching for a given integer is in the set. It accomplishes
 * this by keeping the set of integers in a sorted array and using
 * binary search to find the given integer.
 * <p>
 * The <em>rank</em> and <em>contains</em> operations take
 * logarithmic time in the worst case.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/12oop">Section
 * 1.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class StaticSETofInts {

  private final int[] a;

  /**
   * Initializes a set of integers specified by the integer array.
   *
   * @param keys
   *     the array of integers
   *
   * @throws IllegalArgumentException
   *     if the array contains duplicate integers
   */
  public StaticSETofInts(final int[] keys) {
    this.a = new int[keys.length];
    for (var i = 0; i < keys.length; i++) {
      this.a[i] = keys[i];
    }

    Arrays.sort(this.a);

    for (var i = 1; i < this.a.length; i++) {
      if (this.a[i] == this.a[i - 1]) {
        throw new IllegalArgumentException("Argument arrays contains duplicate keys.");
      }
    }
  }

  /**
   * Is the key in this set of integers?
   *
   * @param key
   *     the search key
   *
   * @return true if the set of integers contains the key; false otherwise
   */
  public boolean contains(final int key) {
    return rank(key) != -1;
  }

  /**
   * Returns either the index of the search key in the sorted array
   * (if the key is in the set) or -1 (if the key is not in the set).
   *
   * @param key
   *     the search key
   *
   * @return the number of keys in this set less than the key (if the key is in the set)
   * or -1 (if the key is not in the set).
   */
  public int rank(final int key) {
    var lo = 0;
    var hi = this.a.length - 1;
    while (lo <= hi) {
      final var mid = lo + (hi - lo) / 2;
      if (key < this.a[mid]) {
        hi = mid - 1;
      } else if (key > this.a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
