package com.github.mdssjc.design_patterns.behavioral.interpreter;

/**
 * Nonterminal Expression.
 *
 * @author Marcelo dos Santos
 *
 */
public class NonterminalExpression implements AbstractExpression {

  private final AbstractExpression left;
  private final AbstractExpression right;

  public NonterminalExpression(final AbstractExpression left, final AbstractExpression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public int interpret(final Context context) {
    return this.left.interpret(context) + this.right.interpret(context);
  }
}
