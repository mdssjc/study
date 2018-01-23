package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Decorator implements Component {

  private final Component component;

  protected Decorator(final Component component) {
    this.component = component;
  }

  @Override
  public String operation() {
    return this.component.operation();
  }
}
