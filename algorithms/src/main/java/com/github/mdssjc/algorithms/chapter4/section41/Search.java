package com.github.mdssjc.algorithms.chapter4.section41;

/**
 * Search Interface.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Search {

  /**
   * Is {@code v} connected to {@code s}?
   *
   * @param v
   *     The vertex
   *
   * @return {@code true} if there is a path, {@code false} otherwise
   */
  boolean marked(int v);

  /**
   * How many vertices are connected to {@code s}?
   *
   * @return the number of vertices connected to the source vertex {@code s}
   */
  int count();
}
