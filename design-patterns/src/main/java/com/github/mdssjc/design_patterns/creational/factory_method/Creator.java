package com.github.mdssjc.design_patterns.creational.factory_method;

/**
 * Creator.
 *
 * @author Marcelo dos Santos
 */
public interface Creator {

  default Product factoryMethod() {
    return new ConcreteProduct("Creator");
  }
}
