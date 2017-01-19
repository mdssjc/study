package com.github.mdssjc.dp.template_method.base;

import com.github.mdssjc.dp.template_method.Template;
import com.github.mdssjc.dp.template_method.application.ApplicationClassA;
import com.github.mdssjc.dp.template_method.application.ApplicationClassB;

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
    final Template appA = new ApplicationClassA();
    final Template appB = new ApplicationClassB();

    appA.templateMethod();
    appB.templateMethod();
  }
}
