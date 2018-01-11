package com.github.mdssjc.design_patterns.abstract_factory;

/**
 * Concrete Factory.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteFactory1 extends AbstractFactory {

  @Override
  public AbstractProductA createProdutA() {
    return new ProductA1();
  }

  @Override
  public AbstractProductB createProdutB() {
    return new ProductB1();
  }
}
