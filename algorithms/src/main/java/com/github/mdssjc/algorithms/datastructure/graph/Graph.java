package com.github.mdssjc.algorithms.datastructure.graph;

/**
 * Graph.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Graph {

  int v();

  int e();

  void addEdge(int v, int w);

  Iterable<Integer> adj(int v);
}
