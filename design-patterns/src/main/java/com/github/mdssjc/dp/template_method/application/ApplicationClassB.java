package com.github.mdssjc.dp.template_method.application;

import com.github.mdssjc.dp.template_method.framework.FrameworkClass;

/**
 * Classe ApplicationClassB.
 *
 * @author Marcelo dos Santos
 *
 */
public class ApplicationClassB extends FrameworkClass {

  @Override
  public void stepTwo() {
    System.out.println("STEP TWO - Application B");
  }

  @Override
  public void stepThree() {
    System.out.println("STEP THREE - Application B");
  }

  @Override
  public void hook() {
    System.out.println("HOOK - Application B");
  }
}
