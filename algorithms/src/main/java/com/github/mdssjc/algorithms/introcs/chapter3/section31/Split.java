package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

/**
 * Program 3.1.9 Splitting a file.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"DJIA.csv", "4"}, valueFile = true)
public class Split {

  public static void main(final String[] args) {
    Executor.execute(Split.class, args);

    final String name = args[0];
    final int n = Integer.parseInt(args[1]);
    final String delimiter = ",";

    final Out[] out = new Out[n];
    final String baseName = name.substring(0, name.indexOf("."));
    for (int i = 0; i < n; i++) {
      out[i] = new Out(baseName + i + ".txt");
    }

    final In in = new In(name);
    while (in.hasNextLine()) {
      final String line = in.readLine();
      final String[] fields = line.split(delimiter);
      for (int i = 0; i < n; i++) {
        out[i].println(fields[i]);
      }
    }
  }
}
