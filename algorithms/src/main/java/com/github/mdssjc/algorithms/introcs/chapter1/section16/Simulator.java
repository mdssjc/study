package com.github.mdssjc.algorithms.introcs.chapter1.section16;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Transition.class, "Program 1.6.1 Computing the transition matrix");
    Executor.execute(RandomSurfer.class, "Program 1.6.2 Simulating a random surfer");
    Executor.execute(Markov.class, "Program 1.6.3 Mixing a Markov chain");
  }
}
