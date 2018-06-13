package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.chapter1.section11.Counter;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.*;

/**
 * Interval2D client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({".2", ".5", ".5", ".6", "10000"})
public class Interval2DClient {

  public static void main(final String[] args) {
    Executor.execute(Interval2DClient.class, args);

    final double xmin = Double.parseDouble(args[0]);
    final double xmax = Double.parseDouble(args[1]);
    final double ymin = Double.parseDouble(args[2]);
    final double ymax = Double.parseDouble(args[3]);
    final int trials = Integer.parseInt(args[4]);

    final Interval1D xInterval = new Interval1D(xmin, xmax);
    final Interval1D yInterval = new Interval1D(ymin, ymax);
    final Interval2D box = new Interval2D(xInterval, yInterval);
    box.draw();

    final com.github.mdssjc.algorithms.chapter1.section11.Counter counter = new Counter("hits");
    for (int t = 0; t < trials; t++) {
      final double x = StdRandom.uniform(0.0, 1.0);
      final double y = StdRandom.uniform(0.0, 1.0);
      final Point2D point = new Point2D(x, y);

      if (box.contains(point)) {
        counter.increment();
      } else {
        point.draw();
      }
    }

    StdOut.println(counter);
    StdOut.printf("box area = %.2f%n", box.area());
  }
}
