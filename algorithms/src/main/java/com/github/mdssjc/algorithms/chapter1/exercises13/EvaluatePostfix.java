package com.github.mdssjc.algorithms.chapter1.exercises13;

import edu.princeton.cs.algs4.Stack;

/**
 * Classe EvaluatePostfix.
 *
 * @author Marcelo dos Santos
 *
 */
public class EvaluatePostfix {

  private final Stack<Double> vals = new Stack<>();

  public void add(final String exp) {
    if (exp.equals("(") || exp.equals(")")) {
      ;
    } else if (exp.equals("+") || exp.equals("-") ||
        exp.equals("*") || exp.equals("/") ||
        exp.equals("sqrt")) {
      double v = this.vals.pop();
      if (exp.equals("+")) {
        v = this.vals.pop() + v;
      } else if (exp.equals("-")) {
        v = this.vals.pop() - v;
      } else if (exp.equals("*")) {
        v = this.vals.pop() * v;
      } else if (exp.equals("/")) {
        v = this.vals.pop() / v;
      } else if (exp.equals("sqrt")) {
        v = Math.sqrt(v);
      }
      this.vals.push(v);
    } else {
      this.vals.push(Double.parseDouble(exp));
    }
  }

  public double result() {
    return this.vals.pop();
  }
}
