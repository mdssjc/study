package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 9.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( value = {"( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"}, input = {"1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"} )
public class Ex9 {

  public static void main(final String[] args) {
    Executor.execute(Ex9.class, args);

    final StackLinkedList<String> in = new StackLinkedList<>();
    while (StdIn.hasNextLine()) {
      in.push(StdIn.readString());
    }

    final StackLinkedList<String> result = new StackLinkedList<>();
    int cntVals = 0;
    int cntOps = 0;
    int cntParenLevel = 0;
    while (!in.isEmpty()) {
      final String o = in.pop();

      result.push(o);
      switch (o) {
        case ")":
          cntParenLevel++;
          break;
        case "+":
        case "-":
        case "*":
        case "/":
          cntOps++;
          break;
        default:
          cntVals++;
          if (cntParenLevel > 0 && cntOps > 0 && cntVals == 2) {
            cntVals = 0;
            while (cntOps > 0 && cntParenLevel > 0) {
              cntParenLevel--;
              cntOps--;
              result.push("(");
            }
          }
      }
    }

    while (cntParenLevel > 0) {
      cntParenLevel--;
      result.push("(");
    }

    final StringBuilder sb = new StringBuilder();
    for (final String s : result) {
      sb.append(s + " ");
    }

    StdOut.println(sb);
    assert sb.equals(args[0]);
  }
}