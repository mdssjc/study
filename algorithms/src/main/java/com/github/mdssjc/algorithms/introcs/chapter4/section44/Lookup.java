package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Program 4.4.1 Dictionary lookup.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"amino.csv", "0", "3"}, input = {"TTA", "ABC", "TCT"})
@TestDrive(value = {"amino.csv", "3", "0"}, input = {"Glycine"})
@TestDrive(value = {"ip.csv", "0", "1"}, input = {"www.google.com"})
@TestDrive(value = {"ip.csv", "1", "0"}, input = {"216.239.41.99"})
@TestDrive(value = {"DJIA.csv", "0", "1"}, input = {"29-Oct-29"})
public class Lookup {

  public static void main(final String[] args) {
    Executor.execute(Lookup.class, args);

    final In in = new In(args[0]);
    final int keyField = Integer.parseInt(args[1]);
    final int valField = Integer.parseInt(args[2]);

    final String[] database = in.readAllLines();
    StdRandom.shuffle(database);

    final ST<String, String> st = new ST<>();
    for (int i = 0; i < database.length; i++) {
      final String[] tokens = database[i].split(",");
      final String key = tokens[keyField];
      final String val = tokens[valField];
      st.put(key, val);
    }

    while (!StdIn.isEmpty()) {
      final String s = StdIn.readString();
      StdOut.println(st.get(s));
    }
  }
}
