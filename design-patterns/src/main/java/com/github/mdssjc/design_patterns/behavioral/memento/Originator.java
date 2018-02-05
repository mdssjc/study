package com.github.mdssjc.design_patterns.behavioral.memento;

import java.util.Random;

/**
 * Originator.
 *
 * @author Marcelo dos Santos
 *
 */
public class Originator {

  private final Random random;
  private String state;

  public Originator() {
    this.random = new Random();
  }

  public void setMemento(final Memento m) {
    this.state = m.getState();
  }

  public Memento createMemento() {
    this.state = newState();
    return new Memento(this.state);
  }

  private String newState() {
    return String.format("Originator %03d", this.random.nextInt(999));
  }

  @Override
  public String toString() {
    return this.state;
  }
}
