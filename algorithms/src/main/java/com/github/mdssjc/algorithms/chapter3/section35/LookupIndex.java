package com.github.mdssjc.algorithms.chapter3.section35;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.*;

/**
 * LookupIndex Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"aminoI.csv", ","}, valueFile = true, input = {"Serine", "TCG"})
@TestDrive(value = {"movies.txt", "/"}, valueFile = true, input = {"Bacon, Kevin", "Tin Men (1987)"})
public class LookupIndex {

  public static void main(final String[] args) {
    Executor.execute(LookupIndex.class, args);

    final In in = new In(args[0]);
    final String sp = args[1];

    final ST<String, Queue<String>> st = new ST<>();
    final ST<String, Queue<String>> ts = new ST<>();

    while (in.hasNextLine()) {
      final String[] a = in.readLine()
                           .split(sp);
      final String key = a[0];
      for (int i = 1; i < a.length; i++) {
        final String val = a[i];
        if (!st.contains(key)) {
          st.put(key, new Queue<>());
        }
        if (!ts.contains(val)) {
          ts.put(val, new Queue<>());
        }
        st.get(key)
          .enqueue(val);
        ts.get(val)
          .enqueue(key);
      }
    }

    while (!StdIn.isEmpty()) {
      final String query = StdIn.readLine();
      if (st.contains(query)) {
        for (final String s : st.get(query)) {
          StdOut.println(" " + s);
        }
      }
      if (ts.contains(query)) {
        for (final String s : ts.get(query)) {
          StdOut.println(" " + s);
        }
      }
    }
  }
}
