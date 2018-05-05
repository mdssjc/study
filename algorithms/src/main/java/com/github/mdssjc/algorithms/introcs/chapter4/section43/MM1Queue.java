package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.introcs.chapter3.section32.Histogram;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 4.3.7 M/M/1 queue simulation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"0.167", "0.25"})
@TestDrive({"0.167", "0.20"})
public class MM1Queue {

  public static void main(final String[] args) {
    Executor.execute(MM1Queue.class, args);

    final double lambda = Double.parseDouble(args[0]);
    final double mu = Double.parseDouble(args[1]);
    final Histogram hist = new Histogram(60 + 1);
    final Queue<Double> queue = new Queue<>();
    double nextArrival = StdRandom.exp(lambda);
    double nextService = nextArrival + StdRandom.exp(mu);
    StdDraw.enableDoubleBuffering();

    while (true) {
      while (nextArrival < nextService) {
        queue.enqueue(nextArrival);
        nextArrival += StdRandom.exp(lambda);
      }

      final double wait = nextService - queue.dequeue();
      hist.addDataPoint(Math.min(60, (int) Math.round(wait)));
      StdDraw.clear();
      hist.draw();
      StdDraw.show();
      StdDraw.pause(20);
      if (queue.isEmpty()) {
        nextService = nextArrival + StdRandom.exp(mu);
      } else {
        nextService = nextService + StdRandom.exp(mu);
      }
    }
  }
}
