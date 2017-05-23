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

  int rank(int key, int[] a);

  enum METHOD {
    ITERATIVE {
      @Override
      public BinarySearch get() {
        return new BinarySearchIterative();
      }
    },
    RECURSIVE {
      @Override
      public BinarySearch get() {
        return new BinarySearchRecursive();
      }
    };

    public abstract BinarySearch get();
  }
}
