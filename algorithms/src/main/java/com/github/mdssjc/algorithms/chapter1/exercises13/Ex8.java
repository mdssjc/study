package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.ResizingArrayStack;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 8.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = {"it was - the best - of times - - - it was - the - -"} )
public class Ex8 {

  public static void main(final String[] args) {
    Executor.execute(Ex8.class, args);

    final ResizingArrayStack<String> stack = new ResizingArrayStack<>();
    while (StdIn.hasNextLine()) {
      final String s = StdIn.readString();
      if ("-".equals(s)) {
        stack.pop();
      } else {
        stack.push(s);
      }
    }

    StdOut.print("Conteúdo: ");
    for (final String s : stack) {
      StdOut.print(s + " ");
    }
    StdOut.println();
    StdOut.println("Total: " + stack.size());
  }
}
