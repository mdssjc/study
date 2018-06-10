package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Graph.class, "Program 4.5.1 Graph data type");
    Executor.execute(IndexGraph.class, "Program 4.5.2 Using a graph to invert an index");
    Executor.execute(PathFinder.class, "Program 4.5.3 Shortest-paths client");
    Executor.execute(PathFinder.class, "Program 4.5.4 Shortest-paths implementation");
    Executor.execute(SmallWorld.class, "Program 4.5.5 Small-world test");
    Executor.execute(Performer.class, "Program 4.5.6 Performer–performer graph");
  }
}
