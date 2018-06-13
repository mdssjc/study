package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.chapter1.section11.StaticSETofInts;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Whitelist client.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "tinyW.txt", valueFile = true, input = "tinyT.txt", inputFile = true)
@TestDrive(value = "largeW.txt", valueFile = true, input = "largeT.txt", inputFile = true)
public class Whitelist {

  public static void main(final String[] args) {
    Executor.execute(Whitelist.class, args);

    final int[] white = new In(args[0]).readAllInts();
    final StaticSETofInts set = new StaticSETofInts(white);

    while (!StdIn.isEmpty()) {
      final int key = StdIn.readInt();
      if (!set.contains(key)) {
        StdOut.println(key);
      }
    }
  }
}
