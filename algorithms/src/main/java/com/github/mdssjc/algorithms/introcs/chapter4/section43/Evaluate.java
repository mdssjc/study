package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.3.5 Expression evaluation.
 * <p>
 * Compilation:  javac Evaluate.java
 * Execution:    java Evaluate
 * Dependencies: Stack.java
 * <p>
 * Evaluates (fully parenthesized) arithmetic expressions using
 * Dijkstra's two-stack algorithm.
 * <p>
 * % java Evaluate
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * 101.0
 * <p>
 * % java Evaulate
 * ( ( 1 + sqrt ( 5 ) ) / 2.0 )
 * 1.618033988749895
 * <p>
 * <p>
 * <p>
 * Remarkably, Dijkstra's algorithm computes the same
 * answer if we put each operator *after* its two operands
 * instead of *between* them.
 * <p>
 * % java Evaluate
 * ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + )
 * 101.0
 * <p>
 * Moreover, in such expressions, all parentheses are redundant!
 * Removing them yields an expression known as a postfix expression.
 * 1 2 3 + 4 5 * * +
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )")
@TestDrive(input = "( ( 1 + sqrt ( 5 ) ) / 2.0 )")
public class Evaluate {

  public static void main(final String[] args) {
    Executor.execute(Evaluate.class, args);

    final var ops = new Stack<String>();
    final var vals = new Stack<Double>();

    while (!StdIn.isEmpty()) {
      final var s = StdIn.readString();
      if (s.equals("(")) {
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
      } else if (s.equals(")")) {
        final var op = ops.pop();
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
      } else {
        vals.push(Double.parseDouble(s));
      }
    }
    StdOut.println(vals.pop());
  }
}
