package com.github.mdssjc.design_patterns.creational.prototype;

/**
 * Concrete Prototype.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcretePrototype2 implements Prototype {

  @Override
  public Prototype clone() {
    try {
      return (Prototype) super.clone();
    } catch (final CloneNotSupportedException ignored) {
    }
    return null;
  }

  @Override
  public String message() {
    return "Concrete Prototype 2";
  }
}
