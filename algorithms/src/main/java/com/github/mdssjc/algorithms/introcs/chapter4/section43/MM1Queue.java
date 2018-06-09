package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.introcs.chapter3.section32.Histogram;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 4.3.7 M/M/1 queue simulation.
 * <p>
 * Compilation:  javac MM1Queue.java
 * Execution:    java MM1Queue lambda mu
 * Dependencies: Queue.java Histogram.java
 * <p>
 * Simulate an M/M/1 queue where arrivals and departures are Poisson
 * processes with arrival rate lambda and service rate mu.
 * <p>
 * % java MM1Queue .20 .33
 * <p>
 * % java MM1Queue .20 .25
 * <p>
 * % java MM1Queue .20 .21
 * <p>
 * <p>
 * Remarks
 * -------
 * - We assume the interrarrival and service times are independent.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"0.20", "0.33"})
@TestDrive({"0.20", "0.25"})
@TestDrive({"0.20", "0.21"})
public class MM1Queue {

  public static void main(final String[] args) {
    Executor.execute(MM1Queue.class, args);

    final var lambda = Double.parseDouble(args[0]);
    final var mu = Double.parseDouble(args[1]);

    final var queue = new Queue<Double>();
    var nextArrival = StdRandom.exp(lambda);
    var nextDeparture = Double.POSITIVE_INFINITY;

    // double expectedWait = 1.0 / (mu - lambda);

    var totalWait = 0.0;
    long customersServiced = 0;

    final var hist = new Histogram(60 + 1);

    StdDraw.setCanvasSize(1000, 600);
    StdDraw.enableDoubleBuffering();

    while (true) {
      if (nextArrival <= nextDeparture) {
        if (queue.isEmpty()) {
          nextDeparture = nextArrival + StdRandom.exp(mu);
        }
        queue.enqueue(nextArrival);
        nextArrival += StdRandom.exp(lambda);
      } else {
        final var wait = nextDeparture - queue.dequeue();
        hist.addDataPoint(Math.min(60, (int) (Math.round(wait))));
        totalWait += wait;
        customersServiced++;
        StdDraw.clear();
        hist.draw();
        StdDraw.show();
        StdDraw.pause(30);
        if (queue.isEmpty()) {
          nextDeparture = Double.POSITIVE_INFINITY;
        } else {
          nextDeparture += StdRandom.exp(mu);
        }
      }
    }
  }
}
