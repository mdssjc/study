package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 34.
 * <p>
 * Filtering.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx34 {

  public static void main(final String[] args) {
    Executor.execute(CEx34.class, args);

    StdOut.println("Array: ");
    StdOut.println("Print the k th smallest value, for k less than 100.");
    StdOut.println("Print the N numbers in increasing order.");
    StdOut.println("Print the N numbers in random order.");

    StdOut.println("Filter: ");
    StdOut.println("Print the maximum and minimum numbers.");
    StdOut.println("Print the median of the numbers.");
    StdOut.println("Print the sum of the squares of the numbers.");
    StdOut.println("Print the average of the N numbers.");
    StdOut.println("Print the percentage of numbers greater than the average.");
  }
}
