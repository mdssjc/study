package com.github.mdssjc.design_patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject.
 *
 * @author Marcelo dos Santos
 */
public abstract class Subject {

  private final List<Observer> observers;

  public Subject() {
    this.observers = new ArrayList<>();
  }

  public void attach(final Observer observer) {
    this.observers.add(observer);
  }

  public void detach(final Observer observer) {
    this.observers.remove(observer);
  }

  public void doNotify() {
    this.observers.forEach(observer -> observer.update(this));
  }

  public abstract String getState();

  public abstract void setState(String state);
}
