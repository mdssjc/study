package com.github.mdssjc.algorithms.datastructure.graph.concrete;

import com.github.mdssjc.algorithms.datastructure.bag.Bag;
import com.github.mdssjc.algorithms.datastructure.bag.concrete.BagLinkedList;
import com.github.mdssjc.algorithms.datastructure.graph.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Implementação do Undirected Graph.
 *
 * @author Marcelo dos Santos
 *
 */
public class UndirectedGraph implements Graph {

  private final int v;
  private int e;
  private final Bag<Integer>[] adj;

  public UndirectedGraph(final int v) {
    this.v = v;
    this.e = 0;
    this.adj = new Bag[v];
    for (int i = 0; i < this.v; i++) {
      this.adj[i] = new BagLinkedList<>();
    }
  }

  public UndirectedGraph(final In in) {
    this(in.readInt());
    final int e = in.readInt();
    for (int i = 0; i < e; i++) {
      final int v = in.readInt();
      final int w = in.readInt();
      addEdge(v, w);
    }
  }

  @Override
  public int v() {
    return this.v;
  }

  @Override
  public int e() {
    return this.e;
  }

  @Override
  public void addEdge(final int v, final int w) {
    this.adj[v].add(w);
    this.adj[w].add(v);
    this.e++;
  }

  @Override
  public Iterable<Integer> adj(final int v) {
    return this.adj[v];
  }
}
