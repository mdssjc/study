package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.5 Similarity detection.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"5", "10000"}, input = "documents.txt", inputFile = true)
public class CompareDocuments {

  public static void main(final String[] args) {
    Executor.execute(CompareDocuments.class, args);

    final int k = Integer.parseInt(args[0]);
    final int d = Integer.parseInt(args[1]);

    final String[] filenames = StdIn.readAllStrings();
    final int n = filenames.length;
    final Sketch[] a = new Sketch[n];
    for (int i = 0; i < n; i++) {
      a[i] = new Sketch(new In(filenames[i]).readAll(), k, d);
    }
    StdOut.print(" ");
    for (int j = 0; j < n; j++) {
      StdOut.printf("%8.4s", filenames[j]);
    }
    StdOut.println();
    for (int i = 0; i < n; i++) {
      StdOut.printf("%.4s", filenames[i]);
      for (int j = 0; j < n; j++) {
        StdOut.printf("%8.2f", a[i].similarTo(a[j]));
      }
      StdOut.println();
    }
  }
}
