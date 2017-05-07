package com.github.mdssjc.simuduck;

public class Duck {

  FlyBehavior flyBehavior;
  QuackBehavior quackBehavior;

  public void performFly() {
    flyBehavior.fly();
  }

  public void performQuack() {
    quackBehavior.quick();
  }
}
