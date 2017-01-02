package com.github.mdssjc.algorithms.chapter1.section15;

/**
 * Union Find (UF).
 *
 * @author Marcelo dos Santos
 *
 */
public interface UF {

  /**
   * Add connection between p and q.
   *
   * @param p
   *     Site p
   * @param q
   *     Site q
   */
  void union(int p, int q);

  /**
   * Component identifier for p ( 0 to N-1).
   *
   * @param p
   *     Site p
   *
   * @return Identifier of site
   */
  int find(int p);

  /**
   * Return true if p and q are in the same component.
   *
   * @param p
   *     Site p
   * @param q
   *     Site q
   *
   * @return Result of predicate
   */
  default boolean connected(final int p, final int q) {
    return find(p) == find(q);
  }

  /**
   * Number of components.
   *
   * @return Result of count
   */
  int count();
}
