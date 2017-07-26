package com.github.mdssjc.algorithms.chapter4.section41;

/**
 * Paths Interface.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Paths {

  /**
   * Is there a path from {@code s} to {@code v}?
   *
   * @param v
   *     The vertex
   *
   * @return {@code true} if there is a path, {@code false} otherwise
   */
  boolean hasPathTo(int v);

  /**
   * Path from {@code s} to {@code v}; null if no such path.
   *
   * @param v
   *     The vertex
   *
   * @return the sequence of vertices on a path between the source vertex {@code
   * s} and vertex {@code v}, as an Iterable
   */
  Iterable<Integer> pathTo(int v);
}
