package com.github.mdssjc.simuduck;

import com.github.mdssjc.simuduck.fly.FlyWithWings;
import com.github.mdssjc.simuduck.quack.Quack;

public class MallardDuck extends Duck  implements Quackable{

  public MallardDuck() {
    setQuackBehavior(new Quack());
    setFlyBehavior(new FlyWithWings());
  }

  @Override
  public void display() {
    System.out.println("I'm a real Mallard duck");
  }

  @Override
  public void quack() {
    System.out.println("Quack");
  }
}
