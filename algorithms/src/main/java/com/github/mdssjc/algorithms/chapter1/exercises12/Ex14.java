package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 14.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"Marcelo,08/28/2016,1520.55", "Marcelo,08/28/2016,1520.55"} )
@TestDrive( {"Marcelos,08/28/2016,1520.55", "Marcelo,08/28/2016,1520.55"} )
@TestDrive( {"Marcelo,08/27/2016,1520.55", "Marcelo,08/28/2016,1520.55"} )
@TestDrive( {"Marcelo,08/28/2016,1520.56", "Marcelo,08/28/2016,1520.55"} )
@TestDrive( {"Marcelo,08/29/2016,1520.55", "Marcelo,08/28/2016,1520.55"} )
public class Ex14 {

  public static void main(final String[] args) {
    Executor.execute(Ex14.class, args);

    final TransactionEx14 log1 = new TransactionEx14(args[0]);
    final TransactionEx14 log2 = new TransactionEx14(args[1]);

    StdOut.println(log1.equals(log2) + " " + log1.compareTo(log2));
  }
}
