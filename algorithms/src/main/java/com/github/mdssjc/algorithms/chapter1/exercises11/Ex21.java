package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 21.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "Marcelo 10 20\nMaria 5 6\nJosé 15 10" )
public class Ex21 {

  public static void main(final String[] args) {
    Executor.execute(Ex21.class, args);

    StdOut.printf("%10s | %7s | %7s | %5s%n",
                  "Name", "Value 1", "Value 2", "Result");

    while (StdIn.hasNextLine()) {
      final String[] xs = StdIn.readLine()
                               .split(" ");

      final String name = xs[0];
      final int value1 = Integer.parseInt(xs[1]);
      final int value2 = Integer.parseInt(xs[2]);
      final double result = (double) (value1) / value2;

      StdOut.printf("%10s | %7d | %7d | %5.3f%n",
                    name, value1, value2, result);
    }
  }
}
