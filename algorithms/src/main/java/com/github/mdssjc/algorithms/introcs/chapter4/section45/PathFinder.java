package com.github.mdssjc.algorithms.introcs.chapter4.section45;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.5.3 Shortest-paths client.
 * Program 4.5.4 Shortest-paths implementation.
 * <p>
 * Compilation:  javac PathFinder.java
 * Execution:    java Pathfinder input.txt delimiter source
 * Dependencies: Queue.java Stack.java Graph.java
 * Data files:   https://introcs.cs.princeton.edu/45graph/routes.txt
 * https://introcs.cs.princeton.edu/45graph/movies.txt
 * <p>
 * Runs breadth first search algorithm from source s on a graph G.
 * After preprocessing the graph, can process shortest path queries
 * from s to any vertex t.
 * <p>
 * % java PathFinder routes.txt " " JFK
 * LAX
 *    JFK
 *    ORD
 *    PHX
 *    LAX
 * distance 3
 * MCO
 *    JFK
 *    MCO
 * distance 1
 * DFW
 *    JFK
 *    ORD
 *    DFW
 * distance 2
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"routes.txt", " ", "JFK"}, input = {"LAX", "MCO", "DFW"})
public class PathFinder {

  private final ST<String, String> prev = new ST<>();
  private final ST<String, Integer> dist = new ST<>();

  public PathFinder(final Graph G, final String s) {
    final Queue<String> queue = new Queue<>();
    queue.enqueue(s);
    this.dist.put(s, 0);

    while (!queue.isEmpty()) {
      final var v = queue.dequeue();
      for (final var w : G.adjacentTo(v)) {
        if (!this.dist.contains(w)) {
          queue.enqueue(w);
          this.dist.put(w, 1 + this.dist.get(v));
          this.prev.put(w, v);
        }
      }
    }
  }

  public boolean hasPathTo(final String v) {
    return this.dist.contains(v);
  }

  public int distanceTo(final String v) {
    if (!hasPathTo(v)) {
      return Integer.MAX_VALUE;
    }
    return this.dist.get(v);
  }

  public Iterable<String> pathTo(String v) {
    final Stack<String> path = new Stack<>();
    while (v != null && this.dist.contains(v)) {
      path.push(v);
      v = this.prev.get(v);
    }
    return path;
  }

  public static void main(final String[] args) {
    Executor.execute(PathFinder.class, args);

    final var filename = args[0];
    final var delimiter = args[1];
    final var G = new Graph(filename, delimiter);
    final var s = args[2];
    final var pf = new PathFinder(G, s);
    while (!StdIn.isEmpty()) {
      final var t = StdIn.readLine();
      for (final var v : pf.pathTo(t)) {
        StdOut.println("   " + v);
      }
      StdOut.println("distance " + pf.distanceTo(t));
    }
  }
}
