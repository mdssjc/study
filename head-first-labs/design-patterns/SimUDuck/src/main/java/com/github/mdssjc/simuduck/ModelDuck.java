package com.github.mdssjc.simuduck;

import com.github.mdssjc.simuduck.fly.FlyNoWay;
import com.github.mdssjc.simuduck.quack.Quack;

public class ModelDuck extends Duck {

  public ModelDuck() {
    setFlyBehavior(new FlyNoWay());
    setQuackBehavior(new Quack());
  }

  @Override
  public void display() {
    System.out.println("I'm a model duck");
  }
}
