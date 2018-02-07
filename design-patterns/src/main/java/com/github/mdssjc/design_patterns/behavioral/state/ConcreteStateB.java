package com.github.mdssjc.design_patterns.behavioral.state;

/**
 * Concrete State B.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteStateB implements State {

  @Override
  public void handle() {
    System.out.println("Concrete State B");
  }
}
