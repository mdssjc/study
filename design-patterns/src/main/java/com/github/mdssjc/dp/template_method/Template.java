package com.github.mdssjc.dp.template_method;

/**
 * Classe Abstrata Template.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Template {

  public final void templateMethod() {
    stepOne();
    stepTwo();
    stepThree();
    hook();
  }

  public final void stepOne() {
    System.out.println("STEP ONE - Framework");
  }

  public abstract void stepTwo();

  public abstract void stepThree();

  public void hook() {
  }
}
