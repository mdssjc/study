package com.github.mdssjc.algorithms.introcs.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Percolation.class, "Program 2.4.1 Percolation scaffolding");
    Executor.execute(VerticalPercolation.class, "Program 2.4.2 Vertical percolation detection");
    Executor.execute(PercolationVisualizer.class, "Program 2.4.3 Visualization client");
    Executor.execute(PercolationProbability.class, "Program 2.4.4 Percolation probability estimate");
    Executor.execute(Percolation.class, "Program 2.4.5 Percolation detection");
    Executor.execute(PercolationPlot.class, "Program 2.4.6 Adaptive plot client");
  }
}
