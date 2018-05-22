package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.1 Graph data type.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tinyGraph.txt", inputFile = true)
public class Graph {

  private final ST<String, SET<String>> st;

  public Graph() {
    this.st = new ST<>();
  }

  public Graph(final String filename, final String delimiter) {
    this.st = new ST<>();
    final In in = new In(filename);
    while (in.hasNextLine()) {
      final String line = in.readLine();
      final String[] names = line.split(delimiter);
      for (int i = 1; i < names.length; i++) {
        addEdge(names[0], names[i]);
      }
    }
  }

  public void addEdge(final String v, final String w) {
    if (!this.st.contains(v)) {
      this.st.put(v, new SET<>());
    }
    if (!this.st.contains(w)) {
      this.st.put(w, new SET<>());
    }
    this.st.get(v)
           .add(w);
    this.st.get(w)
           .add(v);
  }

  public Iterable<String> adjacentTo(final String v) {
    return this.st.get(v);
  }

  public Iterable<String> vertices() {
    return this.st.keys();
  }

  @Override
  public String toString() {
    String s = "";
    for (final String v : vertices()) {
      s += v + " ";
      for (final String w : adjacentTo(v)) {
        s += w + " ";
      }
      s += "\n";
    }
    return s;
  }

  public static void main(final String[] args) {
    Executor.execute(Graph.class, args);

    final Graph G = new Graph();
    while (!StdIn.isEmpty()) {
      G.addEdge(StdIn.readString(), StdIn.readString());
    }
    StdOut.print(G);
  }
}
