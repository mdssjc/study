package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Complex.class, "Program 3.3.1 Complex number (alternate)");
    Executor.execute(Counter.class, "Program 3.3.2 Counter");
    Executor.execute(Vector.class, "Program 3.3.3 Spatial vectors");
    Executor.execute(Sketch.class, "Program 3.3.4 Document sketch");
    Executor.execute(CompareDocuments.class, "Program 3.3.5 Similarity detection");
  }
}
