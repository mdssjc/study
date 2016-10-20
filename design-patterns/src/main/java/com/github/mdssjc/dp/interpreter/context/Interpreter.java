package com.github.mdssjc.dp.interpreter.context;

import com.github.mdssjc.dp.interpreter.expression.AbstractExpression;
import com.github.mdssjc.dp.interpreter.expression.concrete.NonterminalExpression;
import com.github.mdssjc.dp.interpreter.expression.concrete.TerminalExpression;

import java.util.Stack;

/**
 * Classe Interpreter.
 *
 * @author Marcelo dos Santos
 *
 */
public class Interpreter {

  public int evaluate(final String expression) {
    final Stack<AbstractExpression> stack = new Stack<>();
    for (final String s : expression.split(" ")) {
      if (isOperator(s)) {
        final AbstractExpression right = stack.pop();
        final AbstractExpression left = stack.pop();
        stack.push(getOperator(s, left, right));
      } else {
        final AbstractExpression i = new TerminalExpression(Integer.parseInt(s));
        stack.push(i);
      }
    }
    return stack.pop().interpret();
  }

  private AbstractExpression getOperator(final String operator, final AbstractExpression left, final AbstractExpression right) {
    switch (operator) {
      case "+":
        return new NonterminalExpression(left, right);
    }
    throw new RuntimeException("Unknown operator: " + operator);
  }

  private boolean isOperator(final String s) {
    return s.equals("+");
  }
}
