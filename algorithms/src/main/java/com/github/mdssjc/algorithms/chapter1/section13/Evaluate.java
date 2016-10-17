package com.github.mdssjc.algorithms.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Evaluate Class.
 * <p>
 * Dijkstra’s two-Stack Algorithm for expression evaluation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )" )
@TestDrive( input = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )" )
public class Evaluate {

  public static void main(final String[] args) {
    Executor.execute(Evaluate.class, args);

    final Stack<String> ops = new Stack<>();
    final Stack<Double> vals = new Stack<>();

    while (!StdIn.isEmpty()) { // Read token, push if operator.
      final String s = StdIn.readString();
      if (s.equals("(")) {
        ;
      } else if (s.equals("+")) {
        ops.push(s);
      } else if (s.equals("-")) {
        ops.push(s);
      } else if (s.equals("*")) {
        ops.push(s);
      } else if (s.equals("/")) {
        ops.push(s);
      } else if (s.equals("sqrt")) {
        ops.push(s);
      } else if (s.equals(")")) { // Pop, evaluate, and push result if token is
        // ")".
        final String op = ops.pop();
        double v = vals.pop();
        if (op.equals("+")) {
          v = vals.pop() + v;
        } else if (op.equals("-")) {
          v = vals.pop() - v;
        } else if (op.equals("*")) {
          v = vals.pop() * v;
        } else if (op.equals("/")) {
          v = vals.pop() / v;
        } else if (op.equals("sqrt")) {
          v = Math.sqrt(v);
        }
        vals.push(v);
      } // Token not operator or paren: push double value.
      else {
        vals.push(Double.parseDouble(s));
      }
    }

    StdOut.println(vals.pop());
  }
}
