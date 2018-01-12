package com.github.mdssjc.design_patterns.builder;

/**
 * Builder.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Builder {

  void buildPartA();

  void buildPartB();

  void buildPartC();

  Product getResult();
}
