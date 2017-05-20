package com.github.mdssjc.algorithms.chapter3.section35;

import com.github.mdssjc.algorithms.datastructure.set.concrete.HashSET;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * WhiteFilter Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "list.txt", valueFile = true, input = "tinyTale.txt", inputFile = true)
public class WhiteFilter {

  public static void main(final String[] args) {
    Executor.execute(WhiteFilter.class, args);

    final HashSET<String> set = new HashSET<>();

    final In in = new In(args[0]);
    while (!in.isEmpty()) {
      set.add(in.readString());
    }
    while (!StdIn.isEmpty()) {
      final String word = StdIn.readString();
      if (set.contains(word)) {
        StdOut.println(word);
      }
    }
  }
}
