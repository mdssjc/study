package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Web Exercise 41.
 * <p>
 * Wget.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "http://introcs.cs.princeton.edu/data/codes.csv" )
public class WEx41 {

  public static void main(final String[] args) {
    Executor.execute(WEx41.class, args);

    final String url = args[0];
    final String filename = url.substring(url.lastIndexOf('/') + 1);

    try (Scanner scanner = new Scanner(new URL(url).openStream());
         PrintStream printStream = new PrintStream(filename)) {
      while (scanner.hasNext()) {
        final String line = scanner.nextLine();
        StdOut.println(line);
        printStream.println(line);
      }
    } catch (final IOException e) {
      StdOut.println(e.getMessage());
    }
  }
}
