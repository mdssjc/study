package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

/**
 * Program 3.1.7 Concatenating files.
 * <p>
 * Compilation:  javac Cat.java
 * Execution:    java Cat file1.txt file2.txt file3.txt output.txt
 * Dependencies: In.java
 * Data files:   http://www.cs.princeton.edu/introcs/31datatype/in1.jpg
 *               http://www.cs.princeton.edu/introcs/31datatype/in2.jpg
 * <p>
 * Reads in text files specified as the first command-line
 * parameters, concatenates them, and writes the result to
 * filename specified as the last command line parameter.
 * <p>
 * % more in1.txt
 * This is
 * <p>
 * % more in2.txt
 * a tiny
 * test.
 * <p>
 * % java Cat in1.txt in2.txt out.txt
 * <p>
 * % more out.txt .
 * This is
 * a tiny
 * test.
 *
 * @author Marcelo dos Santos
 */
@TestDrive(value = {"in1.txt", "in2.txt", "out.txt"}, valueFile = true)
public class Cat {

  public static void main(final String[] args) {
    Executor.execute(Cat.class, args);

    final var out = new Out(args[args.length - 1]);
    for (var i = 0; i < args.length - 1; i++) {
      final var in = new In(args[i]);
      final var s = in.readAll();
      out.println(s);
      in.close();
    }
    out.close();
  }
}
