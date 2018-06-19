package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.chapter1.section0.Cat;
import com.github.mdssjc.algorithms.chapter1.section0.Counter;
import com.github.mdssjc.algorithms.chapter1.section0.Knuth;
import com.github.mdssjc.algorithms.chapter1.section0.Whitelist;
import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Cat.class, "Concatenate files");
    Executor.execute(Knuth.class, "Knuth shuffle");
    Executor.execute(Counter.class, "Counter data type");
    Executor.execute(Flips.class, "Counter client that simulates t coin flips");
    Executor.execute(FlipsMax.class, "Example of a static method with object arguments and return values");
    Executor.execute(Rolls.class, "Counter client that simulates T rolls of a die");
    Executor.execute(Whitelist.class, "Whitelist client");
//    Executor.execute(VectorClient.class, "Euclidean vector client");
    Executor.execute(BasicDate.class, "Basic Date: implementation");
    Executor.execute(SmallDate.class, "Small Date: alternate implementation");
//    Executor.execute(DateClient.class, "Date client");
//    Executor.execute(TransactionClient.class, "Transaction client");
//    Executor.execute(Point2DClient.class, "Point2D client");
//    Executor.execute(Interval1DClient.class, "Interval1D client");
//    Executor.execute(Interval2DClient.class, "Interval2D client");
    Executor.execute(AccumulatorClient.class, "Accumulator client");
    Executor.execute(Accumulator.class, "Accumulator data type");
    Executor.execute(VisualAccumulator.class, "Visual Accumulator data type");
  }
}
