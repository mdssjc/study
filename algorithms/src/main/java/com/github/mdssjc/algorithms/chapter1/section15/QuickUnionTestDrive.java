package com.github.mdssjc.algorithms.chapter1.section15;

import com.github.mdssjc.algorithms.datastructure.union_find.UF;
import com.github.mdssjc.algorithms.datastructure.union_find.concrete.QuickUnion;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Quick Union test drive.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "tinyUF.txt", inputFile = true)
@TestDrive(input = "mediumUF.txt", inputFile = true)
@TestDrive(input = "largeUF.txt", inputFile = true)
public class QuickUnionTestDrive {

  public static void main(final String[] args) {
    Executor.execute(QuickUnionTestDrive.class, args);

    final int n = StdIn.readInt();
    final UF uf = new QuickUnion(n);

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
