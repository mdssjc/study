package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 4.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex4 {

  public static void main(final String[] args) {
    Executor.execute(Ex4.class, args);

    StdOut.println("Yes. If the subarrays are in sorted order," +
                   " then the inplace merge produces proper output." +
                   " If one subarray is not in sorted order, then" +
                   " its entries will appear in the output in the" +
                   " same order that they appear in the input " +
                   "(with entries from the other subarray intermixed).");
  }
}
