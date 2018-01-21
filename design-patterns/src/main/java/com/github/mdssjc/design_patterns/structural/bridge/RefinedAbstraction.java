package com.github.mdssjc.design_patterns.structural.bridge;

/**
 * Refined Abstraction.
 *
 * @author Marcelo dos Santos
 *
 */
public class RefinedAbstraction implements Abstraction {

  private final Implementor implementor;

  public RefinedAbstraction(final Implementor implementor) {
    this.implementor = implementor;
  }

  @Override
  public String operation() {
    return this.implementor.operationImp();
  }
}
