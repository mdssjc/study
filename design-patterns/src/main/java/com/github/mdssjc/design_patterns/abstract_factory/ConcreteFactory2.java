package com.github.mdssjc.design_patterns.abstract_factory;

/**
 * Concrete Factory.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteFactory2 implements AbstractFactory {

  @Override
  public AbstractProductA createProdutA() {
    return new ProductA2();
  }

  @Override
  public AbstractProductB createProdutB() {
    return new ProductB2();
  }
}
