package com.github.mdssjc.design_patterns.behavioral.interpreter;

/**
 * Abstract Expression.
 *
 * @author Marcelo dos Santos
 *
 */
public interface AbstractExpression {

  int interpret(Context context);
}
