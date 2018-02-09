package com.github.mdssjc.design_patterns.behavioral.template_method;

/**
 * Concrete Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteClass extends AbstractClass {

  @Override
  public String primitiveOperation1() {
    return "Concrete";
  }

  @Override
  public String primitiveOperation2() {
    return "Class";
  }
}
