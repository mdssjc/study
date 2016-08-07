package com.github.mdssjc.algorithms.chapter1.section12;

import static com.github.mdssjc.algorithms.utils.MainUtils.execute;
import static com.github.mdssjc.algorithms.utils.MainUtils.toXSS;

/**
 * Simulator Class.
 * 
 * @author Marcelo dos Santos
 * 
 */
public class Simulator {

  public static void main(final String[] args) {
    // Counter
    execute(Counter::main);

    // Flips
    execute(Flips::main, toXSS(1000));

    // FlipsMax
    execute(FlipsMax::main, toXSS(1000000));
  }
}
