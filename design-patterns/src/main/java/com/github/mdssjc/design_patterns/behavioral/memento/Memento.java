package com.github.mdssjc.design_patterns.behavioral.memento;

/**
 * Memento.
 *
 * @author Marcelo dos Santos
 *
 */
public class Memento {

  private String state;

  public Memento(final String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }

  public void setState(final String state) {
    this.state = state;
  }
}
