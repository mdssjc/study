package com.github.mdssjc.simuduck;

public class GooseAdapter implements Quackable {

  private final Goose goose;
  private final Observable observable;

  public GooseAdapter(final Goose goose) {
    this.goose = goose;
    this.observable = new Observable(this);
  }

  @Override
  public void quack() {
    this.goose.honk();
    notifyObservers();
  }

  @Override
  public void registerObserver(final Observer observer) {
    this.observable.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    this.observable.notifyObservers();
  }

  @Override
  public String toString() {
    return "Goose pretending to be a Duck";
  }
}
