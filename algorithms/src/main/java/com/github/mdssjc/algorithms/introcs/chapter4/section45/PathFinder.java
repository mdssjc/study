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
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"routes.txt", " ", "JFK"}, input = {"LAX", "DFW"})
public class PathFinder {

  private final ST<String, Integer> dist;
  private final ST<String, String> prev;

  public PathFinder(final Graph G, final String s) {
    this.prev = new ST<>();
    this.dist = new ST<>();
    final Queue<String> queue = new Queue<>();
    queue.enqueue(s);
    this.dist.put(s, 0);
    while (!queue.isEmpty()) {
      final String v = queue.dequeue();
      for (final String w : G.adjacentTo(v)) {
        if (!this.dist.contains(w)) {
          queue.enqueue(w);
          this.dist.put(w, 1 + this.dist.get(v));
          this.prev.put(w, v);
        }
      }
    }
  }

  public int distanceTo(final String v) {
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

    final String filename = args[0];
    final String delimiter = args[1];
    final Graph G = new Graph(filename, delimiter);
    final String s = args[2];
    final PathFinder pf = new PathFinder(G, s);

    while (StdIn.hasNextLine()) {
      final String t = StdIn.readLine();
      final int d = pf.distanceTo(t);
      for (final String v : pf.pathTo(t)) {
        StdOut.println(" " + v);
      }
      StdOut.println("distance " + d);
    }
  }
}
