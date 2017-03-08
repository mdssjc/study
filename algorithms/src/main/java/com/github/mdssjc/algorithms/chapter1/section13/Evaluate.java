package com.github.mdssjc.algorithms.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Dijkstra’s two-Stack Algorithm for expression evaluation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )")
@TestDrive(input = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )")
public class Evaluate {

  public static void main(final String[] args) {
    Executor.execute(Evaluate.class, args);

    final Stack<String> ops = new Stack<>();
    final Stack<Double> vals = new Stack<>();

    while (!StdIn.isEmpty()) {
      final String s = StdIn.readString();
      switch (s) {
        case "(":
          break;
        case "+":
          ops.push(s);
          break;
        case "-":
          ops.push(s);
          break;
        case "*":
          ops.push(s);
          break;
        case "/":
          ops.push(s);
          break;
        case "sqrt":
          ops.push(s);
          break;
        case ")":
          final String op = ops.pop();
          double v = vals.pop();
          switch (op) {
            case "+":
              v = vals.pop() + v;
              break;
            case "-":
              v = vals.pop() - v;
              break;
            case "*":
              v = vals.pop() * v;
              break;
            case "/":
              v = vals.pop() / v;
              break;
            case "sqrt":
              v = Math.sqrt(v);
              break;
          }
          vals.push(v);
          break;
        default:
          vals.push(Double.parseDouble(s));
          break;
      }
    }
    StdOut.println(vals.pop());
  }
}
