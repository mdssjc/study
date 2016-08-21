package com.github.mdssjc.algorithms.chapter1.section12;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Whitelist Class - StaticSETofInts Client.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Whitelist {

  public static void main(final String[] args) {
    final int[] w = In.readInts(args[0]);
    final StaticSETofInts set = new StaticSETofInts(w);
    while (!StdIn.isEmpty()) {
      // Read key, print if not in whitelist.
      final int key = StdIn.readInt();
      if (!set.contains(key)) {
        StdOut.println(key);
      }
    }
  }
}
