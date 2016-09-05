package com.github.mdssjc.algorithms.chapter1.section13;

import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Stats Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = { "100 99 101 120 98 107 109 81 101 90" })
public class Stats {

  public static void main(final String[] args) {
    final Bag<Double> numbers = new Bag<>();

    while (!StdIn.isEmpty()) {
      numbers.add(StdIn.readDouble());
    }

    final int N = numbers.size();
    double sum = 0.0;
    for (final double x : numbers) {
      sum += x;
    }

    final double mean = sum / N;
    sum = 0.0;
    for (final double x : numbers) {
      sum += (x - mean) * (x - mean);
    }

    final double std = Math.sqrt(sum / (N - 1));

    StdOut.printf("Mean: %.2f\n", mean);
    StdOut.printf("Std dev: %.2f\n", std);
  }
}
