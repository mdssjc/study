package com.github.mdssjc.algorithms.search;

import com.github.mdssjc.algorithms.search.concrete.BinarySearchIterative;
import com.github.mdssjc.algorithms.search.concrete.BinarySearchRecursive;

/**
 * Binary Search O(log n).
 *
 * @author Marcelo dos Santos
 *
 */
public interface BinarySearch {

  static BinarySearch of(final BS type) {
    if (type == BS.ITERATIVE) {
      return new BinarySearchIterative();
    }
    return new BinarySearchRecursive();
  }

  int rank(int key, int[] a);

  enum BS {ITERATIVE, RECURSIVE}
}
