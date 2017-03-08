package com.github.mdssjc.algorithms.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Stats.class, "Stats Class");
    Executor.execute(QueueClient.class, "Sample Queue client");
    Executor.execute(Reverse.class, "Sample Stack client");
    Executor.execute(Evaluate.class, "Dijkstra’s two-Stack Algorithm for expression evaluation");
  }
}
