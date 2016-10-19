package com.github.mdssjc.dp.decorator;

import com.github.mdssjc.dp.decorator.component.Component;

/**
 * Classe Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public class Decorator extends Component {

  private final Component component;

  public Decorator(final Component component) {
    this.component = component;
  }

  @Override
  public String text() {
    return "[" + this.component.text() + "]";
  }
}
