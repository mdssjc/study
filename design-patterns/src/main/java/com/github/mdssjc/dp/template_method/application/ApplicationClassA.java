package com.github.mdssjc.dp.template_method.application;

import com.github.mdssjc.dp.template_method.framework.FrameworkClass;

/**
 * Classe ApplicationClassA.
 *
 * @author Marcelo dos Santos
 *
 */
public class ApplicationClassA extends FrameworkClass {

  @Override
  public void stepTwo() {
    System.out.println("STEP TWO - Application A");
  }

  @Override
  public void stepThree() {
    System.out.println("STEP THREE - Application A");
  }
}
