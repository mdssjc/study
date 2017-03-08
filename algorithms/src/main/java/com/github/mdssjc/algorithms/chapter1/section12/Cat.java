package com.github.mdssjc.algorithms.chapter1.section12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * Concatenate files.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"in1.txt", "in2.txt", "out.txt"}, valueFile = true)
public class Cat {

  public static void main(final String[] args) {
    Executor.execute(Cat.class, args);

    final Out out = new Out(args[args.length - 1]);
    for (int i = 0; i < args.length - 1; i++) {
      final String s = new In(args[i]).readAll();
      out.println(s);
    }
    out.close();
  }
}
