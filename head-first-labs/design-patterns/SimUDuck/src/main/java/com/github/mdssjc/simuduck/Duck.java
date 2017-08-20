package com.github.mdssjc.simuduck;

import com.github.mdssjc.simuduck.fly.FlyBehavior;
import com.github.mdssjc.simuduck.quack.QuackBehavior;

public abstract class Duck {

  private FlyBehavior flyBehavior;
  private QuackBehavior quackBehavior;

  public abstract void display();

  public void performFly() {
    this.flyBehavior.fly();
  }

  public void performQuack() {
    this.quackBehavior.quack();
  }

  public void swim() {
    System.out.println("All ducks float, even decoys!");
  }

  public void setFlyBehavior(final FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(final QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
