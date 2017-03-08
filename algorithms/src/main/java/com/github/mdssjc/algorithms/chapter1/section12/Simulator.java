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
    Executor.execute(Flips.class, "Counter client that simulates t coin flips");
    Executor.execute(FlipsMax.class, "Example of a static method with object arguments and return values");
    Executor.execute(Rolls.class, "Counter client that simulates T rolls of a die");
    Executor.execute(Counter.class, "Counter data type");
    Executor.execute(BasicDate.class, "Basic Date: implementation");
    Executor.execute(SmallDate.class, "Small Date: alternate implementation");
    Executor.execute(Accumulator.class, "Accumulator data type");
    Executor.execute(VisualAccumulator.class, "Visual Accumulator data type");
    Executor.execute(Whitelist.class, "StaticSETofInts client");
  }
}
