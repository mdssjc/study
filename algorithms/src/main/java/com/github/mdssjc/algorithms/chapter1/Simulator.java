package com.github.mdssjc.algorithms.chapter1;

import com.github.mdssjc.algorithms.utils.Executor;
import edu.princeton.cs.algs4.StdOut;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    StdOut.println("1 Fundamentals");
    Executor.execute(Euclid.class, "Euclid's algorithm");

    StdOut.println("1.1 Basic Programming Model");
    Executor.execute(BinarySearch.class, "Binary search");
    Executor.execute(TypicalArrayCodes.class, "Typical array-processing code");
    Executor.execute(SquareRoot.class, "Square Root");
  }
}
