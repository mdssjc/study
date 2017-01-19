package com.github.mdssjc.dp.template_method.base;

import com.github.mdssjc.dp.template_method.application.ApplicationClassA;
import com.github.mdssjc.dp.template_method.application.ApplicationClassB;
import com.github.mdssjc.dp.template_method.framework.FrameworkClass;

/**
 * Test drive do padrão de projeto Template Method.
 * <p>
 * Design Pattern
 * Behavioral - Template Method
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final FrameworkClass appA = new ApplicationClassA();
    final FrameworkClass appB = new ApplicationClassB();

    appA.templateMethod();
    appB.templateMethod();
  }
}
