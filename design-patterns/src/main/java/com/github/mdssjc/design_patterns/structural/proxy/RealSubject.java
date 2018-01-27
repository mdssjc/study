package com.github.mdssjc.design_patterns.structural.proxy;

/**
 * Real Subject.
 *
 * @author Marcelo dos Santos
 *
 */
public class RealSubject implements Subject {

  @Override
  public String request() {
    return "Real Subject";
  }
}
