package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Charge.class, "Program 3.2.1 Charged particle");
    Executor.execute(Stopwatch.class, "Program 3.2.2 Stopwatch");
    Executor.execute(Histogram.class, "Program 3.2.3 Histogram");
    Executor.execute(Turtle.class, "Program 3.2.4 Turtle graphics");
    Executor.execute(Spiral.class, "Program 3.2.5 Spira mirabilis");
    Executor.execute(Complex.class, "Program 3.2.6 Complex number");
    Executor.execute(Mandelbrot.class, "Program 3.2.7 Mandelbrot set");
    Executor.execute(StockAccount.class, "Program 3.2.8 Stock account");
  }
}
