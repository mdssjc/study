package com.github.mdssjc.design_patterns.creational.bridge;

/**
 * Concrete Implementor.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteImplementorA implements Implementor {

  @Override
  public String operationImp() {
    return "Concrete Implementor A";
  }
}
