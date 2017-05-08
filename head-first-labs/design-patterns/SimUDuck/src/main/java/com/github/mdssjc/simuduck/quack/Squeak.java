package com.github.mdssjc.simuduck.quack;

public class Squeak implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Squeak");
  }
}
