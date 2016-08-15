package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 * 
 * @author Marcelo dos Santos
 * 
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Counter.class);
    Executor.execute(Flips.class);
    Executor.execute(FlipsMax.class);
    Executor.execute(Rolls.class);
    Executor.execute(BasicDate.class);
    Executor.execute(SmallDate.class);
    Executor.execute(Accumulator.class);
    Executor.execute(VisualAccumulator.class);
  }
}
