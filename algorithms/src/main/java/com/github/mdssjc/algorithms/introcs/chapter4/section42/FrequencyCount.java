package com.github.mdssjc.algorithms.introcs.chapter4.section42;

import com.github.mdssjc.algorithms.introcs.chapter3.section33.Counter;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.2.7 Frequency counts.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "leipzig1M.txt", inputFile = true)
public class FrequencyCount {

  public static void main(final String[] args) {
    Executor.execute(FrequencyCount.class, args);

    final String[] words = StdIn.readAllStrings();
    Merge.sort(words);
    final Counter[] zipf = new Counter[words.length];
    int m = 0;
    for (int i = 0; i < words.length; i++) {
      if (i == 0 || !words[i].equals(words[i - 1])) {
        zipf[m++] = new Counter(words[i], words.length);
      }
      zipf[m - 1].increment();
    }
    Merge.sort(zipf, 0, m);
    for (int j = m - 1; j >= 0; j--) {
      StdOut.println(zipf[j]);
    }
  }
}
