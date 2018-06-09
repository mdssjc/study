package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.introcs.chapter3.section33.Counter;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.7 Frequency counts.
 * <p>
 * Compilation:  javac FrequencyCount.java
 * Execution:    java FrequencyCount < file.txt
 * Dependencies: StdIn.java Counter.java
 * Data files:   http://www.cs.princeton.edu/introcs/43sort/mobydicks.txt
 *               http://www.cs.princeton.edu/introcs/43sort/Leipzig1M.txt
 *               http://www.cs.princeton.edu/introcs/43sort/Leipzig100K.txt
 *               http://www.cs.princeton.edu/introcs/43sort/Leipzig200KM.txt
 * <p>
 * Read in a sequence of words, separated by whitespace.
 * Compute the number of times each word appears, and print,
 * sorted by frequency.
 * <p>
 * % java FrequencyCount < mobydick.txt
 * the: 13527
 * of: 6374
 * and: 5857
 * a: 4457
 * to: 4388
 * in: 3773
 * that: 2666
 * his: 2404
 * I: 1742
 * with: 1615
 * ...
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "mobydick.txt", inputFile = true)
public class FrequencyCount {

  public static void main(final String[] args) {
    final var s = StdIn.readAll();
    final var words = s.split("\\s+");

    Merge.sort(words);

    final var zipf = new Counter[words.length];
    var m = 0;
    for (var i = 0; i < words.length; i++) {
      if (i == 0 || !words[i].equals(words[i - 1])) {
        zipf[m++] = new Counter(words[i], words.length);
      }
      zipf[m - 1].increment();
    }

    Merge.sort(zipf, 0, m);
    for (var j = m - 1; j >= 0; j--) {
      StdOut.println(zipf[j]);
    }
  }
}
