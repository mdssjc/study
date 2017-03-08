package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * StaticSETofInts client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
public class Whitelist {

  public static void main(final String[] args) {
    Executor.execute(Whitelist.class, args);

    final int[] w = new In(args[0]).readAllInts();
    final StaticSETofInts set = new StaticSETofInts(w);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (!set.contains(key)) {
        StdOut.println(key);
      }
    }
  }
}
