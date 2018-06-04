package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(StdRandom.class, "Program 2.2.1 Random number library");
    Executor.execute(StdArrayIO.class, "Program 2.2.2 Array I/O library");
    Executor.execute(IFS.class, "Program 2.2.3 Iterated function systems");
    Executor.execute(StdStats.class, "Program 2.2.4 Data analysis library");
    Executor.execute(StdStats.class, "Program 2.2.5 Plotting data values in an array");
    Executor.execute(Bernoulli.class, "Program 2.2.6 Bernoulli trials");
  }
}
