package com.github.mdssjc.algorithms.chapter2.section24;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Multiway Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"m1.txt", "m2.txt", "m3.txt"}, valueFile = true)
public class Multiway {

  private static void merge(final In[] streams) {
    final int n = streams.length;
    final IndexMinPQ<String> pq = new IndexMinPQ<>(n);
    for (int i = 0; i < n; i++) {
      if (!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }
    while (!pq.isEmpty()) {
      StdOut.println(pq.minKey());
      final int i = pq.delMin();
      if (!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Multiway.class, args);

    final int n = args.length;
    final In[] streams = new In[n];
    for (int i = 0; i < n; i++) {
      streams[i] = new In(args[i]);
    }
    merge(streams);
  }
}
