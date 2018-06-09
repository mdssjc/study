package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.4.5 Dedup filter.
 *
 *  Compilation:  javac DeDup.java
 *  Execution:    java DeDup < words.txt
 *  Dependencies: SET.java StdIn.java
 *
 *  Read in a list of words from standard input and print out
 *  each word, removing any duplicates.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "TaleOfTwoCities.txt", inputFile = true)
public class DeDup {

  public static void main(final String[] args) {
    Executor.execute(DeDup.class, args);

    final var distinct = new SET<String>();
    while (!StdIn.isEmpty()) {
      final var key = StdIn.readString();
      if (!distinct.contains(key)) {
        distinct.add(key);
        StdOut.println(key);
      }
    }
  }
}
