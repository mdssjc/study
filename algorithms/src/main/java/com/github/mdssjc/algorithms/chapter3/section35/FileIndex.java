package com.github.mdssjc.algorithms.chapter3.section35;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.SET;

import java.io.File;

/**
 * FileIndex Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"ex1.txt", "ex2.txt", "ex3.txt", "ex4.txt"}, valueFile = true, input = {"age", "best", "was"})
public class FileIndex {

  public static void main(final String[] args) {
    Executor.execute(FileIndex.class, args);

    final ST<String, SET<File>> st = new ST<>();

    for (final String filename : args) {
      final File file = new File(filename);
      final In in = new In(file);
      while (!in.isEmpty()) {
        final String word = in.readString();
        if (!st.contains(word)) {
          st.put(word, new SET<>());
        }
        final SET<File> set = st.get(word);
        set.add(file);
      }
    }

    while (!StdIn.isEmpty()) {
      final String query = StdIn.readString();
      if (st.contains(query)) {
        for (final File file : st.get(query)) {
          StdOut.println(" " + file.getName());
        }
      }
    }
  }
}
