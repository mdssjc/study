package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Vector;

/**
 * Euclidean vector client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class VectorClient {

  public static void main(final String[] args) {
    Executor.execute(VectorClient.class, args);

    final double[] xdata = {1.0, 2.0, 3.0, 4.0};
    final double[] ydata = {5.0, 2.0, 4.0, 1.0};
    final Vector x = new Vector(xdata);
    final Vector y = new Vector(ydata);

    StdOut.println("   x       = " + x);
    StdOut.println("   y       = " + y);

    Vector z = x.plus(y);
    StdOut.println("   z       = " + z);

    z = z.scale(10.0);
    StdOut.println(" 10z       = " + z);

    StdOut.println("  |x|      = " + x.magnitude());
    StdOut.println(" <x, y>    = " + x.dot(y));
    StdOut.println("dist(x, y) = " + x.distanceTo(y));
    StdOut.println("dir(x)     = " + x.direction());
  }
}
