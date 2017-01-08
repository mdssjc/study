package com.github.mdssjc.algorithms.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Quick Union UF Test Drive.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "tinyUF.txt", inputFile = true )
@TestDrive( input = "mediumUF.txt", inputFile = true )
@TestDrive( input = "largeUF.txt", inputFile = true )
public class QuickUnionUFTestDrive {

  public static void main(final String[] args) {
    Executor.execute(QuickUnionUFTestDrive.class, args);

    final int n = StdIn.readInt();
    final UF uf = new QuickUnionUF(n);
    while (!StdIn.isEmpty()) {
      final int p = StdIn.readInt();
      final int q = StdIn.readInt();
      if (uf.connected(p, q)) {
        continue;
      }
      uf.union(p, q);
      StdOut.println(p + " " + q);
    }
    StdOut.println(uf.count() + " components");
  }
}
