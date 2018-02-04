package com.github.mdssjc.design_patterns.behavioral.mediator;

/**
 * Colleague.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Colleague {

  private final Mediator mediator;
  private int value;

  public Colleague(final Mediator mediator) {
    this.mediator = mediator;
  }

  public void changed() {
    this.mediator.colleagueChanged(this);
  }

  public abstract String message();

  public int getValue() {
    return this.value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
