package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Flip.class, "Program 1.3.1 Flipping a fair coin");
    Executor.execute(TenHellos.class, "Program 1.3.2 Your first while loop");
    Executor.execute(PowersOfTwo.class, "Program 1.3.3 Computing powers of 2");
    Executor.execute(DivisorPattern.class, "Program 1.3.4 Your first nested loops");
    Executor.execute(HarmonicNumber.class, "Program 1.3.5 Harmonic numbers");
    Executor.execute(Sqrt.class, "Program 1.3.6 Newton’s method");
    Executor.execute(Binary.class, "Program 1.3.7 Converting to binary");
    Executor.execute(Gambler.class, "Program 1.3.8 Gambler’s ruin simulation");
    Executor.execute(Factors.class, "Program 1.3.9 Factoring integers");
  }
}
