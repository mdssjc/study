package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

/**
 * Program 3.1.7 Concatenating files.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"in1.txt", "in2.txt", "out.txt"})
public class Cat {

  public static void main(final String[] args) {
    Executor.execute(Cat.class, args);

    final Out out = new Out(args[args.length - 1]);
    for (int i = 0; i < args.length - 1; i++) {
      final In in = new In(args[i]);
      final String s = in.readAll();
      out.println(s);
    }
  }
}
