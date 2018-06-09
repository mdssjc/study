package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.5 Similarity detection.
 * <p>
 * Compilation:  javac CompareDocuments.java
 * Execution:    java CompareDocuments 5 10000 < documents.txt
 * Data files:   http://www.cs.princeton.edu/introcs/33design/documents.txt
 *               http://www.cs.princeton.edu/introcs/33design/Constitution.txt
 *               http://www.cs.princeton.edu/introcs/33design/TomSawyer.txt
 *               http://www.cs.princeton.edu/introcs/33design/HuckFin.txt
 *               http://www.cs.princeton.edu/introcs/33design/Prejudice.txt
 *               http://www.cs.princeton.edu/introcs/33design/Picture.java
 *               http://www.cs.princeton.edu/introcs/33design/DJIA.csv
 *               http://www.cs.princeton.edu/introcs/33design/Amazon.html
 *               http://www.cs.princeton.edu/introcs/33design/ATCG.txt
 * <p>
 * % java CompareDocuments 5 10000 < documents.txt
 *         Cons    TomS    Huck    Prej    Pict    DJIA    Amaz    ATCG
 * Cons    1.00    0.66    0.60    0.64    0.21    0.18    0.21    0.11
 * TomS    0.66    1.00    0.93    0.88    0.14    0.24    0.18    0.14
 * Huck    0.60    0.93    1.00    0.82    0.10    0.23    0.16    0.12
 * Prej    0.64    0.88    0.82    1.00    0.13    0.25    0.19    0.15
 * Pict    0.21    0.14    0.10    0.13    1.00    0.05    0.38    0.04
 * DJIA    0.18    0.24    0.23    0.25    0.05    1.00    0.16    0.11
 * Amaz    0.21    0.18    0.16    0.19    0.38    0.16    1.00    0.07
 * ATCG    0.11    0.14    0.12    0.15    0.04    0.11    0.07    1.00
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"5", "10000"}, input = "documents.txt", inputFile = true)
public class CompareDocuments {

  public static void main(final String[] args) {
    Executor.execute(CompareDocuments.class, args);

    final var k = Integer.parseInt(args[0]);
    final var d = Integer.parseInt(args[1]);
    final var filenames = StdIn.readAllStrings();
    final var n = filenames.length;

    final var sketches = new Sketch[n];
    for (var i = 0; i < n; i++) {
      final var in = new In(filenames[i]);
      final var text = in.readAll();
      sketches[i] = new Sketch(text, k, d);
    }

    StdOut.print("    ");
    for (var i = 0; i < n; i++) {
      StdOut.printf("%8.4s", filenames[i]);
    }
    StdOut.println();

    for (var i = 0; i < n; i++) {
      StdOut.printf("%.4s", filenames[i]);
      for (var j = 0; j < n; j++) {
        StdOut.printf("%8.2f", sketches[i].similarTo(sketches[j]));
      }
      StdOut.println();
    }
  }
}
