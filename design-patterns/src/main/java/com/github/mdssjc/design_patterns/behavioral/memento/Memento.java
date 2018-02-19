package com.github.mdssjc.design_patterns.behavioral.memento;

/**
 * Memento.
 *
 * @author Marcelo dos Santos
 *
 */
public class Memento {

  private final String state;

  public Memento(final String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }
}
