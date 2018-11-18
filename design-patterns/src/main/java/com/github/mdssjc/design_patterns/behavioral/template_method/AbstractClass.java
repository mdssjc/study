package com.github.mdssjc.design_patterns.behavioral.template_method;

/**
 * Abstract Class.
 *
 * @author Marcelo dos Santos
 */
public abstract class AbstractClass {

  public final void templateMethod() {
    System.out.println(primitiveOperation1() + " " + primitiveOperation2());
  }

  public abstract String primitiveOperation1();

  public String primitiveOperation2() {
    return "";
  }
}
