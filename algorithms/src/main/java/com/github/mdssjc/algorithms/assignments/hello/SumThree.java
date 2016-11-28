package com.github.mdssjc.algorithms.assignments.hello;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Assignment Sum Three.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"2", "5", "8"} )
@TestDrive( {"-2", "5", "-8"} )
public class SumThree {

  public static void main(final String[] args) {
    Executor.execute(SumThree.class, args);

    final int a = Integer.parseInt(args[0]);
    final int b = Integer.parseInt(args[1]);
    final int c = Integer.parseInt(args[2]);
    final int sum = a + b + c;

    StdOut.printf("%d + %d + %d = %d%n", a, b, c, sum);
  }
}
