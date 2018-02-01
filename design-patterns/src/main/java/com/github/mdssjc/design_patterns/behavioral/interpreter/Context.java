package com.github.mdssjc.design_patterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Context.
 *
 * @author Marcelo dos Santos
 *
 */
public class Context {

  private final Map<String, Integer> variables;

  public Context() {
    this.variables = new HashMap<>();
  }

  public int lookup(final String variable) {
    return this.variables.get(variable);
  }

  public void assign(final TerminalExpression variable, final int value) {
    this.variables.put(variable.name(), value);
  }
}
