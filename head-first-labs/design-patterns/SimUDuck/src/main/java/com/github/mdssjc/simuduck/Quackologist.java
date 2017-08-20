package com.github.mdssjc.simuduck;

public class Quackologist implements Observer {

  @Override
  public void update(final QuackObservable duck) {
    System.out.println("Quackologist: " + duck + " just quacked.");
  }
}
