package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

/**
 * Program 3.1.9 Splitting a file.
 * <p>
 * Compilation:  javac Cat.java
 * Execution:    java Split DJIA n delimiter
 * Dependencies: In.java Out.java
 * Data files:   http://www.cs.princeton.edu/introcs/31datatype/DJIA.csv
 * <p>
 * This program uses multiple output streams to split a CSV file
 * into separate files, one for each comma-delimited field.
 * <p>
 * % more DJIA.csv
 * ...
 * 30-Oct-29,230.98,10730000,258.47
 * 29-Oct-29,252.38,16410000,230.07
 * 28-Oct-29,295.18,9210000,260.64
 * 25-Oct-29,299.47,5920000,301.22
 * <p>
 * <p>
 * % java Split DJIA 3 ","
 * % more DJIA2
 * ...
 * 10730000
 * 16410000
 * 9210000
 * 5920000
 * ...
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"DJIA", "3", ","})
public class Split {

  public static void main(final String[] args) {
    Executor.execute(Split.class, args);

    final var name = args[0];
    final var n = Integer.parseInt(args[1]);
    final var delimiter = args[2];

    final var out = new Out[n];
    for (var i = 0; i < n; i++) {
      out[i] = new Out(name + i);
    }

    final var in = new In(name + ".csv");
    while (in.hasNextLine()) {
      final var line = in.readLine();
      final var fields = line.split(delimiter);
      for (var i = 0; i < n; i++) {
        out[i].println(fields[i]);
      }
    }
  }
}
