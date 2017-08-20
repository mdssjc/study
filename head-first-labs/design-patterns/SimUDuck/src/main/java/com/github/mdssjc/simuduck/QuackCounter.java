package com.github.mdssjc.simuduck;

public class QuackCounter implements Quackable {

  private static int numberOfQuacks;
  private final Quackable duck;

  public QuackCounter(final Quackable duck) {
    this.duck = duck;
  }

  public static int getQuacks() {
    return numberOfQuacks;
  }

  @Override
  public void quack() {
    this.duck.quack();
    numberOfQuacks++;
  }

  @Override
  public void registerObserver(final Observer observer) {
    this.duck.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    this.duck.notifyObservers();
  }
}
