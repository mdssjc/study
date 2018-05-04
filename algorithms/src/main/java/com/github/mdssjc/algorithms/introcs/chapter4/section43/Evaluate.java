package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.3.5 Expression evaluation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )")
@TestDrive(input = "( ( 1 + sqrt ( 5.0 ) ) * 0.5 )")
public class Evaluate {

  public static void main(final String[] args) {
    Executor.execute(Evaluate.class, args);

    final Stack<String> ops = new Stack<>();
    final Stack<Double> values = new Stack<>();
    while (!StdIn.isEmpty()) {
      final String token = StdIn.readString();
      if (token.equals("(")) {
      } else if (token.equals("+")) {
        ops.push(token);
      } else if (token.equals("-")) {
        ops.push(token);
      } else if (token.equals("*")) {
        ops.push(token);
      } else if (token.equals("sqrt")) {
        ops.push(token);
      } else if (token.equals(")")) {
        final String op = ops.pop();
        double v = values.pop();
        if (op.equals("+")) {
          v = values.pop() + v;
        } else if (op.equals("-")) {
          v = values.pop() - v;
        } else if (op.equals("*")) {
          v = values.pop() * v;
        } else if (op.equals("sqrt")) {
          v = Math.sqrt(v);
        }
        values.push(v);
      } else {
        values.push(Double.parseDouble(token));
      }
    }
    StdOut.println(values.pop());
  }
}
