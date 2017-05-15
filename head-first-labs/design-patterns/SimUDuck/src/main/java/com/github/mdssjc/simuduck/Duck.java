package com.github.mdssjc.simuduck;

import com.github.mdssjc.simuduck.fly.FlyBehavior;
import com.github.mdssjc.simuduck.quack.QuackBehavior;

public abstract class Duck {

  private FlyBehavior flyBehavior;
  private QuackBehavior quackBehavior;

  public abstract void display();

  public void performFly() {
    flyBehavior.fly();
  }

  public void performQuack() {
    quackBehavior.quack();
  }

  public void swim() {
    System.out.println("All ducks float, even decoys!");
  }

  public void setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
