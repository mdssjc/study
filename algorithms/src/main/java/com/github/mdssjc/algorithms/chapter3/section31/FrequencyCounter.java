package com.github.mdssjc.algorithms.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Frequency Counter Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "1", input = "tinyTale.txt", inputFile = true)
@TestDrive(value = "8", input = "tale.txt", inputFile = true)
@TestDrive(value = "10", input = "leipzig1M.txt", inputFile = true)
public class FrequencyCounter {

  public static void main(final String[] args) {
    Executor.execute(FrequencyCounter.class, args);

    final int minlen = Integer.parseInt(args[0]); // key-length cutoff
    final ST<String, Integer> st = new ST<>();

    while (!StdIn.isEmpty()) { // Build symbol table and count frequencies.
      final String word = StdIn.readString();
      if (word.length() < minlen) {
        continue; // Ignore short keys.
      }
      if (!st.contains(word)) {
        st.put(word, 1);
      } else {
        st.put(word, st.get(word) + 1);
      }
    }

    // Find a key with the highest frequency count.
    String max = "";
    st.put(max, 0);
    for (final String word : st.keys()) {
      if (st.get(word) > st.get(max)) {
        max = word;
      }
    }
    StdOut.println(max + " " + st.get(max));
  }
}
