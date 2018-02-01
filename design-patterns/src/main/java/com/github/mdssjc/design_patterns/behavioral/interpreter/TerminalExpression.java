package com.github.mdssjc.design_patterns.behavioral.interpreter;

/**
 * Terminal Expression.
 *
 * @author Marcelo dos Santos
 *
 */
public class TerminalExpression implements AbstractExpression {

  private final String variable;

  public TerminalExpression(final String variable) {
    this.variable = variable;
  }

  @Override
  public int interpret(final Context context) {
    return context.lookup(this.variable);
  }

  public String name() {
    return this.variable;
  }
}
