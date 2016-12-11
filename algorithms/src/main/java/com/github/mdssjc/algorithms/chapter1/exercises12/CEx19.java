package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 19.
 * <p>
 * Parsing.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"Marcelo", "08/28/2016", "1520.55"} )
@TestDrive( "Marcelo,08/28/2016,1520.55" )
public class CEx19 {

  public static void main(final String[] args) {
    Executor.execute(CEx19.class, args);

    final TransactionCEx19 transaction;
    if (args.length == 1) {
      transaction = new TransactionCEx19(args[0]);
    } else {
      transaction = new TransactionCEx19(args[0], args[1], args[2]);
    }

    StdOut.println(transaction);
  }
}
