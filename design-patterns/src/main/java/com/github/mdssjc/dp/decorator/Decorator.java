package com.github.mdssjc.dp.decorator;

import com.github.mdssjc.dp.decorator.component.Component;
import lombok.Getter;

/**
 * Classe Abstrata Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Decorator implements Component {

  @Getter
  private final Component component;

  public Decorator(final Component component) {
    this.component = component;
  }

  @Override
  public abstract void operation(final String message);
}
