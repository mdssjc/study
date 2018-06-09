package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdStats;

/**
 * Program 4.3.8 Load balancing simulation.
 * <p>
 * Compilation:  javac LoadBalance.java
 * Execution:    java LoadBalance m n s
 * Dependencies: Queue.java RandomQueue.java StdDraw.java StdStats.java
 * <p>
 * Simulate the process of assignment n items to a set of m servers.
 * Requests are put on the shortest of a sample of s queues chosen
 * at random.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"50", "500", "1"})
@TestDrive({"50", "500", "2"})
public class LoadBalance {

  public static void main(final String[] args) {
    Executor.execute(LoadBalance.class, args);

    final var m = Integer.parseInt(args[0]);
    final var n = Integer.parseInt(args[1]);
    final var s = Integer.parseInt(args[2]);

    final var servers = new RandomQueue<Queue<Integer>>();

    for (var i = 0; i < m; i++) {
      servers.enqueue(new Queue<>());
    }

    for (var j = 0; j < n; j++) {
      var min = servers.sample();
      for (var k = 1; k < s; k++) {
        final var queue = servers.sample();
        if (queue.length() < min.length()) {
          min = queue;
        }
      }

      min.enqueue(j);
    }

    var i = 0;
    final var lengths = new double[m];
    for (final var queue : servers) {
      lengths[i++] = queue.length();
      StdDraw.setYscale(0, 2.0 * n / m);
      StdStats.plotBars(lengths);
    }
  }
}
