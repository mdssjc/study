package com.github.mdssjc.algorithms.introcs.chapter3.section34;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Body.class, "Program 3.4.1 Gravitational body");
    Executor.execute(Universe.class, "Program 3.4.2 N-body simulation");
  }
}
