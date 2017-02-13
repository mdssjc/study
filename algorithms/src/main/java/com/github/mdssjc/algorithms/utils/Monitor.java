package com.github.mdssjc.algorithms.utils;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Monitor Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Monitor {

  private final String monitor;
  private final String[] variables;
  private boolean isLabel;
  private String format;

  public Monitor(final String monitor, final String... variables) {
    this.monitor = monitor;
    this.variables = variables;
    this.isLabel = true;
  }

  private void print(final Comparable[] a) {
    final String[] index = IntStream.range(0, a.length)
                                    .boxed()
                                    .map(String::valueOf)
                                    .toArray(String[]::new);

    this.format = String.format("%%%ds ", String.valueOf(a.length)
                                                .length());

    final String vars = Arrays.stream(this.variables)
                              .map(s -> String.format(this.format, s))
                              .collect(Collectors.joining());
    StdOut.printf("%32s%s%s%n", " ", vars, Arrays.deepToString(index));
  }

  public void print(final String m, final Comparable[] a, final int... xs) {
    print(m, a, " ", xs);
  }

  public void print(final String m, final boolean predicate, final Comparable[] a, final int... xs) {
    print(this.monitor, predicate, a, "", xs);
  }

  public void print(final String m, final boolean predicate, final Comparable[] a, final String message, final int... xs) {
    if (predicate) {
      print(m, a, message, xs);
    }
  }

  public void print(final String m, final Comparable[] a, final String message, final int... xs) {
    if (this.monitor.equals(m)) {
      if (this.isLabel) {
        print(a);
        this.isLabel = false;
      }

      StdOut.printf("%30s: ", message);
      for (int i = xs.length; i < this.variables.length; i++) {
        StdOut.printf(this.format, " ");
      }
      Arrays.stream(xs)
            .boxed()
            .map(s -> String.format(this.format, s))
            .forEach(StdOut::print);
      StdOut.printf("%s%n", Arrays.deepToString(a));
    }
  }

  public boolean test(final String m) {
    return this.monitor.equals(m);
  }

  public boolean test(final String m, final boolean predicate) {
    return test(m) && predicate;
  }
}
