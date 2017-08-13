package com.github.mdssjc.gumball;

import java.io.Serializable;

public interface State extends Serializable {

  void insertQuarter();

  void ejectQuarter();

  void turnCrank();

  void dispensed();
}
