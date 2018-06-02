package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(RandomSeq.class, "Program 1.5.1 Generating a random sequence");
    Executor.execute(TwentyQuestions.class, "Program 1.5.2 Interactive user input");
    Executor.execute(Average.class, "Program 1.5.3 Averaging a stream of numbers");
    Executor.execute(RangeFilter.class, "Program 1.5.4 A simple filter");
    Executor.execute(PlotFilter.class, "Program 1.5.5 Standard input-to-drawing filter");
    Executor.execute(BouncingBall.class, "Program 1.5.6 Bouncing ball");
    Executor.execute(PlayThatTune.class, "Program 1.5.7 Digital signal processing");
  }
}
