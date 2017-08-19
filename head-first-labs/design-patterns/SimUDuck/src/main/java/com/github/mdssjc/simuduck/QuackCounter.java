package com.github.mdssjc.simuduck;

public class QuackCounter implements Quackable {

  private final Quackable duck;
  private static int numberOfQuacks;

  public QuackCounter(final Quackable duck) {
    this.duck = duck;
  }

  @Override
  public void quack() {
    this.duck.quack();
    numberOfQuacks++;
  }

  public static int getQuacks() {
    return numberOfQuacks;
  }
}
