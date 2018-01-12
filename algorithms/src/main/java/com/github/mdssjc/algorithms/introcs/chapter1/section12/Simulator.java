package com.github.mdssjc.algorithms.introcs.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Ruler.class, "Program 1.2.1 String concatenation");
    Executor.execute(IntOps.class, "Program 1.2.2 Integer multiplication and division");
    Executor.execute(Quadratic.class, "Program 1.2.3 Quadratic formula");
    Executor.execute(LeapYear.class, "Program 1.2.4 Leap year");
    Executor.execute(RandomInt.class, "Program 1.2.5 Casting to get a random integer");
  }
}
