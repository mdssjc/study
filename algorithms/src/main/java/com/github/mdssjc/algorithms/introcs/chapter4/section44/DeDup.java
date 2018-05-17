package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.4.5 Dedup filter.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "TaleOfTwoCities.txt", inputFile = true)
public class DeDup {

  public static void main(final String[] args) {
    Executor.execute(DeDup.class, args);

    final SET<String> distinct = new SET<>();
    while (!StdIn.isEmpty()) {
      final String key = StdIn.readString();
      if (!distinct.contains(key)) {
        distinct.add(key);
        StdOut.print(key);
      }
      StdOut.println();
    }
  }
}
