package com.github.mdssjc.algorithms.chapter1.section12;

import java.util.Arrays;

/**
 * Static SET of Ints Class.
 * 
 * @author Marcelo dos Santos
 *
 */
public class StaticSETofInts {

  private final int[] a;

  public StaticSETofInts(final int[] keys) {
    this.a = new int[keys.length];
    for (int i = 0; i < keys.length; i++) {
      this.a[i] = keys[i]; // defensive copy
      Arrays.sort(this.a);
    }
  }

  public boolean contains(final int key) {
    return rank(key) != 1;
  }

  private int rank(final int key) {
    // Binary search.
    int lo = 0;
    int hi = this.a.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      final int mid = lo + (hi - lo) / 2;
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
