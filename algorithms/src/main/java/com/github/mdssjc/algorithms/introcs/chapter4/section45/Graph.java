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
 * <p>
 * Compilation:  javac Graph.java
 * Execution:    java Graph < input.txt
 * Dependencies: ST.java SET.java In.java StdOut.java
 * Data files:   https://introcs.cs.princeton.edu/45graph/tinyGraph.txt
 * <p>
 * Undirected graph data type implemented using a symbol table
 * whose keys are vertices (String) and whose values are sets
 * of neighbors (SET of Strings).
 * <p>
 * Remarks
 * -------
 * - Parallel edges are not allowed
 * - Self-loop are allowed
 * - Adjacency lists store many different copies of the same
 * String. You can use less memory by interning the strings.
 * <p>
 * % java Graph < tinyGraph.txt
 * A: B C G H
 * B: A C H
 * C: A B G
 * G: A C
 * H: A B
 * <p>
 * A: B C G H
 * B: A C H
 * C: A B G
 * G: A C
 * H: A B
 *
 * @author Marcelo dos Santos
 *
 */

/**
 * The {@code Graph} class represents an undirected graph of vertices
 * with string names.
 * It supports the following operations: add an edge, add a vertex,
 * get all of the vertices, iterate over all of the neighbors adjacent
 * to a vertex, is there a vertex, is there an edge between two vertices.
 * Self-loops are permitted; parallel edges are discarded.
 * <p>
 * For additional documentation, see <a href="https://introcs.cs.princeton.edu/45graph">Section
 * 4.5</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by
 * Robert Sedgewick and Kevin Wayne.
 */
@TestDrive(input = "tinyGraph.txt", inputFile = true)
public class Graph {

  private final ST<String, SET<String>> st;

  private int E;

  /**
   * Initializes an empty graph with no vertices or edges.
   */
  public Graph() {
    this.st = new ST<>();
  }

  /**
   * Initializes a graph from the specified file, using the specified delimiter.
   *
   * @param filename
   *     the name of the file
   * @param delimiter
   *     the delimiter
   */
  public Graph(final String filename, final String delimiter) {
    this.st = new ST<>();
    final var in = new In(filename);
    while (in.hasNextLine()) {
      final var line = in.readLine();
      final var names = line.split(delimiter);
      for (var i = 1; i < names.length; i++) {
        addEdge(names[0], names[i]);
      }
    }
  }

  /**
   * Returns the number of vertices in this graph.
   *
   * @return the number of vertices in this graph
   */
  public int V() {
    return this.st.size();
  }

  /**
   * Returns the number of edges in this graph.
   *
   * @return the number of edges in this graph
   */
  public int E() {
    return this.E;
  }

  private void validateVertex(final String v) {
    if (!hasVertex(v)) {
      throw new IllegalArgumentException(v + " is not a vertex");
    }
  }

  /**
   * Returns the degree of vertex v in this graph.
   *
   * @param v
   *     the vertex
   *
   * @return the degree of {@code v} in this graph
   *
   * @throws IllegalArgumentException
   *     if {@code v} is not a vertex in this graph
   */
  public int degree(final String v) {
    validateVertex(v);
    return this.st.get(v)
                  .size();
  }

  /**
   * Adds the edge v-w to this graph (if it is not already an edge).
   *
   * @param v
   *     one vertex in the edge
   * @param w
   *     the other vertex in the edge
   */
  public void addEdge(final String v, final String w) {
    if (!hasVertex(v)) {
      addVertex(v);
    }
    if (!hasVertex(w)) {
      addVertex(w);
    }
    if (!hasEdge(v, w)) {
      this.E++;
    }
    this.st.get(v)
           .add(w);
    this.st.get(w)
           .add(v);
  }

  /**
   * Adds vertex v to this graph (if it is not already a vertex).
   *
   * @param v
   *     the vertex
   */
  public void addVertex(final String v) {
    if (!hasVertex(v)) {
      this.st.put(v, new SET<>());
    }
  }

  /**
   * Returns the vertices in this graph.
   *
   * @return the set of vertices in this graph
   */
  public Iterable<String> vertices() {
    return this.st.keys();
  }

  /**
   * Returns the set of vertices adjacent to v in this graph.
   *
   * @param v
   *     the vertex
   *
   * @return the set of vertices adjacent to vertex {@code v} in this graph
   *
   * @throws IllegalArgumentException
   *     if {@code v} is not a vertex in this graph
   */
  public Iterable<String> adjacentTo(final String v) {
    validateVertex(v);
    return this.st.get(v);
  }

  /**
   * Returns true if v is a vertex in this graph.
   *
   * @param v
   *     the vertex
   *
   * @return {@code true} if {@code v} is a vertex in this graph,
   * {@code false} otherwise
   */
  public boolean hasVertex(final String v) {
    return this.st.contains(v);
  }

  /**
   * Returns true if v-w is an edge in this graph.
   *
   * @param v
   *     one vertex in the edge
   * @param w
   *     the other vertex in the edge
   *
   * @return {@code true} if {@code v-w} is a vertex in this graph,
   * {@code false} otherwise
   *
   * @throws IllegalArgumentException
   *     if either {@code v} or {@code w}
   *     is not a vertex in this graph
   */
  public boolean hasEdge(final String v, final String w) {
    validateVertex(v);
    validateVertex(w);
    return this.st.get(v)
                  .contains(w);
  }

  /**
   * Returns a string representation of this graph.
   *
   * @return string representation of this graph
   */
  @Override
  public String toString() {
    final var s = new StringBuilder();
    for (final var v : this.st) {
      s.append(v + ": ");
      for (final var w : this.st.get(v)) {
        s.append(w + " ");
      }
      s.append('\n');
    }
    return s.toString();
  }

  /**
   * Unit tests the {@code Graph} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(Graph.class, args);

    final var graph = new Graph();
    while (!StdIn.isEmpty()) {
      final var v = StdIn.readString();
      final var w = StdIn.readString();
      graph.addEdge(v, w);
    }

    StdOut.println(graph);

    for (final var v : graph.vertices()) {
      StdOut.print(v + ": ");
      for (final var w : graph.adjacentTo(v)) {
        StdOut.print(w + " ");
      }
      StdOut.println();
    }
  }
}
