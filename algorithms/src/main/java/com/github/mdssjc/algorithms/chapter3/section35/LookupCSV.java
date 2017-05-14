package com.github.mdssjc.algorithms.chapter3.section35;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * LookupCSV Class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"ip.csv", "1", "0"}, valueFile = true, input = "128.112.136.35")
@TestDrive(value = {"DJIA.csv", "0", "3"}, valueFile = true, input = "29-Oct-29")
@TestDrive(value = {"amino.csv", "0", "3"}, valueFile = true, input = "TCC")
@TestDrive(value = {"UPC.csv", "0", "2"}, valueFile = true, input = "0002100001086")
public class LookupCSV {

  public static void main(final String[] args) {
    Executor.execute(LookupCSV.class, args);

    final In in = new In(args[0]);
    final int keyField = Integer.parseInt(args[1]);
    final int valField = Integer.parseInt(args[2]);

    final ST<String, String> st = new ST<>();
    while (in.hasNextLine()) {
      final String line = in.readLine();
      final String[] tokens = line.split(",");
      final String key = tokens[keyField];
      final String val = tokens[valField];
      st.put(key, val);
    }
    while (!StdIn.isEmpty()) {
      final String query = StdIn.readString();
      if (st.contains(query))
        StdOut.println(st.get(query));
    }
  }
}
