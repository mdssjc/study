package com.github.mdssjc.algorithms.chapter4.section41;

/**
 * Connected Components Interface.
 *
 * @author Marcelo dos Santos
 *
 */
public interface CC {

  /**
   * Are {@code v} and {@code w} connected?
   *
   * @param v
   *     One vertex
   * @param w
   *     The other vertex
   *
   * @return {@code true} if vertices {@code v} and {@code w} are in the same
   * connected component; {@code false} otherwise
   */
  boolean connected(int v, int w);

  /**
   * Number of connected components.
   *
   * @return the number of connected components in the graph {@code G}
   */
  int count();

  /**
   * Component identifier for {@code v} (between 0 and count()-1)
   *
   * @param v
   *     The vertex
   *
   * @return the component id of the connected component containing
   * vertex {@code v}
   */
  int id(int v);
}
