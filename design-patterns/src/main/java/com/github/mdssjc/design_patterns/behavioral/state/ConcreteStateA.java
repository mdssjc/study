package com.github.mdssjc.design_patterns.behavioral.state;

/**
 * Concrete State A.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteStateA implements State {

  @Override
  public void handle() {
    System.out.println("Concrete State A");
  }
}
