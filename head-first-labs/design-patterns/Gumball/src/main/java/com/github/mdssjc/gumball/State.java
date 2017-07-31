package com.github.mdssjc.gumball;

public interface State {

  void insertQuarter();

  void ejectQuarter();

  void turnCrank();

  void dispensed();
}
