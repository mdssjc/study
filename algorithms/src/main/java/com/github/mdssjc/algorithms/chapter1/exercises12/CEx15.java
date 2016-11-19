package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 15.
 * <p>
 * File input.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "src/main/resources/intsEven10" )
public class CEx15 {

  public static void main(final String[] args) {
    Executor.execute(CEx15.class, args);

    final int[] ints = readInts(args[0]);
    for (final int n : ints) {
      StdOut.println(n);
    }
  }

  public static int[] readInts(final String name) {
    final In in = new In(name);
    final String input = in.readAll();
    final String[] words = input.split("\\s+");
    final int[] ints = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      ints[i] = Integer.parseInt(words[i]);
    }
    return ints;
  }
}
