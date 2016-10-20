package com.github.mdssjc.dp.interpreter.expression.concrete;

import com.github.mdssjc.dp.interpreter.expression.AbstractExpression;

/**
 * Classe TerminalExpression.
 *
 * @author Marcelo dos Santos
 *
 */
public class TerminalExpression implements AbstractExpression {

  private final int n;

  public TerminalExpression(final int n) {
    this.n = n;
  }

  @Override
  public int interpret() {
    return this.n;
  }
}
