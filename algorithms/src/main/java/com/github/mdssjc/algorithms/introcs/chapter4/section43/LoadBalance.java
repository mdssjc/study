package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdStats;

/**
 * Program 4.3.8 Load balancing simulation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"50", "500", "1"})
@TestDrive({"50", "500", "2"})
public class LoadBalance {

  public static void main(final String[] args) {
    Executor.execute(LoadBalance.class, args);

    final int m = Integer.parseInt(args[0]);
    final int n = Integer.parseInt(args[1]);
    final int size = Integer.parseInt(args[2]);

    final RandomQueue<Queue<Integer>> servers;
    servers = new RandomQueue<>();
    for (int i = 0; i < m; i++) {
      servers.enqueue(new Queue<>());
    }

    for (int j = 0; j < n; j++) {
      Queue<Integer> min = servers.sample();
      for (int k = 1; k < size; k++) {
        final Queue<Integer> queue = servers.sample();
        if (queue.size() < min.size()) {
          min = queue;
        }
      }
      min.enqueue(j);
    }

    int i = 0;
    final double[] lengths = new double[m];
    for (final Queue<Integer> queue : servers) {
      lengths[i++] = queue.size();
    }
    StdDraw.setYscale(0, 2.0 * n / m);
    StdStats.plotBars(lengths);
  }
}
