package com.github.mdssjc.algorithms.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Test Client Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "S E A R C H E X A M P L E")
public class TestClient {

  public static void main(final String[] args) {
    Executor.execute(TestClient.class, args);

    final ST<String, Integer> st;
    st = new ST<>();

    for (int i = 0; !StdIn.isEmpty(); i++) {
      final String key = StdIn.readString();
      st.put(key, i);
    }

    for (final String s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }
  }
}
