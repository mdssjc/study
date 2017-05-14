package com.github.mdssjc.algorithms.chapter3.section35;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Deup Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tinyTale.txt", inputFile = true)
public class DeDup {

  public static void main(final String[] args) {
    Executor.execute(DeDup.class, args);

    final HashSET<String> set = new HashSET<>();

    while (!StdIn.isEmpty()) {
      final String key = StdIn.readString();
      if (!set.contains(key)) {
        set.add(key);
        StdOut.println(key);
      }
    }
  }
}
