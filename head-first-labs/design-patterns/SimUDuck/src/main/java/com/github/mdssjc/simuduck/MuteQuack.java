package com.github.mdssjc.simuduck;

public class MuteQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("<< Silence >>");
  }
}
