package com.github.mdssjc.design_patterns.creational.abstract_factory;

/**
 * Concrete Factory.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteFactory1 implements AbstractFactory {

  @Override
  public AbstractProductA createProdutA() {
    return new ProductA1();
  }

  @Override
  public AbstractProductB createProdutB() {
    return new ProductB1();
  }
}
