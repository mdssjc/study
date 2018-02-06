package com.github.mdssjc.design_patterns.behavioral.observer;

/**
 * Concrete Observer.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteObserver implements Observer {

  @Override
  public void update(final Subject subject) {
    System.out.println(subject.getState());
  }
}
