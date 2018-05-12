package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.introcs.chapter4.section43.Queue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.4.2 Indexing.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"9", "30"}, input = "TaleOfTwoCities.txt", inputFile = true)
public class Index {

  public static void main(final String[] args) {
    Executor.execute(Index.class, args);

    final int minlen = Integer.parseInt(args[0]);
    final int minocc = Integer.parseInt(args[1]);

    final ST<String, Queue<Integer>> st;
    st = new ST<>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      final String word = StdIn.readString();
      if (word.length() < minlen) {
        continue;
      }
      if (!st.contains(word)) {
        st.put(word, new Queue<>());
      }
      final Queue<Integer> queue = st.get(word);
      queue.enqueue(i);
    }

    for (final String s : st) {
      final Queue<Integer> queue = st.get(s);
      if (queue.size() >= minocc) {
        StdOut.println(s + ": " + queue);
      }
    }
  }
}
