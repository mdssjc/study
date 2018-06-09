package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.4.1 Dictionary lookup.
 * <p>
 * Compilation:  javac Lookup.java
 * Execution:    java Lookup file.csv keyField valField
 * Dependencies: ST.java In.java StdIn.java
 * Data files:   http://www.cs.princeton.edu/introcs/44st/amino.csv
 *               http://www.cs.princeton.edu/introcs/44st/ip.csv
 *               http://www.cs.princeton.edu/introcs/44st/DJIA.csv
 *               http://www.cs.princeton.edu/introcs/44st/morse.csv
 *               http://www.cs.princeton.edu/introcs/44st/elements.csv
 *               http://www.cs.princeton.edu/introcs/44st/mktsymbols.csv
 *               http://www.cs.princeton.edu/introcs/44st/toplevel-domain.csv
 * <p>
 * Reads in a set of key-value pairs from a two-column CSV file
 * specified on the command line; then, reads in keys from standard
 * input and prints out corresponding values.
 * <p>
 * % java Lookup amino.csv 0 3      % java Lookup ip.csv 0 1
 * TTA                              www.google.com
 * Leucine                          216.239.41.99
 * ABC
 * Not found                        % java Lookup ip.csv 1 0
 * TCT                              216.239.41.99
 * Serine                           www.google.com
 * <p>
 * % java Lookup amino.csv 3 0      java Lookup DJIA.csv 0 1
 * Glycine                          29-Oct-29
 * GGG                              252.38
 *                                  20-Oct-87
 *                                  1738.74
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"amino.csv", "0", "3"}, input = {"TTA", "ABC", "TCT"})
@TestDrive(value = {"amino.csv", "3", "0"}, input = {"Glycine"})
@TestDrive(value = {"ip.csv", "0", "1"}, input = {"www.google.com"})
@TestDrive(value = {"ip.csv", "1", "0"}, input = {"216.239.41.99"})
@TestDrive(value = {"DJIA.csv", "0", "1"}, input = {"29-Oct-29", "20-Oct-87"})
public class Lookup {

  public static void main(final String[] args) {
    Executor.execute(Lookup.class, args);

    final var in = new In(args[0]);
    final var keyField = Integer.parseInt(args[1]);
    final var valField = Integer.parseInt(args[2]);
    final var database = in.readAllLines();
    final var st = new ST<String, String>();
    for (var i = 0; i < database.length; i++) {
      final var tokens = database[i].split(",");
      final var key = tokens[keyField];
      final var val = tokens[valField];
      st.put(key, val);
    }

    while (!StdIn.isEmpty()) {
      final var s = StdIn.readString();
      if (st.contains(s)) {
        StdOut.println(st.get(s));
      } else {
        StdOut.println("Not found");
      }
    }
  }
}
