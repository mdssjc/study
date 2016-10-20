package com.github.mdssjc.dp.interpreter.expression.concrete;

import com.github.mdssjc.dp.interpreter.expression.AbstractExpression;

/**
 * Classe NonterminalExpression.
 *
 * @author Marcelo dos Santos
 *
 */
public class NonterminalExpression implements AbstractExpression {

  private final AbstractExpression leftExpression;
  private final AbstractExpression rightExpression;

  public NonterminalExpression(final AbstractExpression leftExpression, final AbstractExpression rightExpression) {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }

  @Override
  public int interpret() {
    return this.leftExpression.interpret() + this.rightExpression.interpret();
  }
}
