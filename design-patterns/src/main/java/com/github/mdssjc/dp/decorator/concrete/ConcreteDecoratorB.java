package com.github.mdssjc.dp.decorator.concrete;

import com.github.mdssjc.dp.decorator.Decorator;
import com.github.mdssjc.dp.decorator.component.Component;

/**
 * Classe ConcreteDecoratorB.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteDecoratorB extends Decorator {

  public ConcreteDecoratorB(final Component component) {
    super(component);
  }

  @Override
  public void operation(final String message) {
    getComponent().operation("[BBB]" + message + "[BBB]");
  }
}
