package com.github.mdssjc.simuduck;

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
