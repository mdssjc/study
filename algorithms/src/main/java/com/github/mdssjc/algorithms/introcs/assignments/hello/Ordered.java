package com.github.mdssjc.algorithms.introcs.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Assignment 0: Integers and booleans.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"10", "17", "49"})
@TestDrive({"49", "17", "10"})
@TestDrive({"10", "49", "17"})
public class Ordered {

  public static void main(final String[] args) {
    Executor.execute(Ordered.class, args);

    final int x = Integer.parseInt(args[0]);
    final int y = Integer.parseInt(args[1]);
    final int z = Integer.parseInt(args[2]);

    StdOut.println(x < y && y < z || x > y && y > z);
  }
}
