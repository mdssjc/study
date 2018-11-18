package com.github.mdssjc.design_patterns.behavioral.observer;

/**
 * Concrete Subject.
 *
 * @author Marcelo dos Santos
 */
public class ConcreteSubject extends Subject {

  private String subjectState;

  @Override
  public String getState() {
    return this.subjectState;
  }

  @Override
  public void setState(final String state) {
    this.subjectState = state;
    super.doNotify();
  }
}
