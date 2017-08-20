package com.github.mdssjc.simuduck;

import java.util.ArrayList;
import java.util.List;

public class Observable implements QuackObservable {

  private final List<Observer> observers;
  private final QuackObservable duck;

  public Observable(final QuackObservable duck) {
    this.observers = new ArrayList<>();
    this.duck = duck;
  }

  @Override
  public void registerObserver(final Observer observer) {
    this.observers.add(observer);
  }

  @Override
  public void notifyObservers() {
    for (final Observer observer : this.observers) {
      observer.update(this.duck);
    }
  }
}
