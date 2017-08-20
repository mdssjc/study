package com.github.mdssjc.simuduck;

import com.github.mdssjc.simuduck.fly.FlyWithWings;
import com.github.mdssjc.simuduck.quack.Quack;

public class MallardDuck extends Duck implements Quackable {

  private final Observable observable;

  public MallardDuck() {
    setQuackBehavior(new Quack());
    setFlyBehavior(new FlyWithWings());
    this.observable = new Observable(this);
  }

  @Override
  public void display() {
    System.out.println("I'm a real Mallard duck");
  }

  @Override
  public void quack() {
    System.out.println("Quack");
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
    return "Mallard Duck";
  }
}
