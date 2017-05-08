package com.github.mdssjc.simuduck;

public class Squeak implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Squeak");
  }
}
