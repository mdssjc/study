package com.github.mdssjc.design_patterns.abstract_factory;

/**
 * Abstract Factory.
 *
 * @author Marcelo dos Santos
 *
 */
public interface AbstractFactory {

  AbstractProductA createProdutA();

  AbstractProductB createProdutB();
}
