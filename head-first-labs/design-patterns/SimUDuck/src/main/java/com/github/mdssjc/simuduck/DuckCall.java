package com.github.mdssjc.simuduck;

public class DuckCall implements Quackable {

  private final Observable observable;

  public DuckCall() {
    this.observable = new Observable(this);
  }

  @Override
  public void quack() {
    System.out.println("Kwak");
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
    return "Duck Call";
  }
}
