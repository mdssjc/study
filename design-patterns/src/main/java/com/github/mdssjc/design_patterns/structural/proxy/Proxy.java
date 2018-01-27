package com.github.mdssjc.design_patterns.structural.proxy;

/**
 * Proxy.
 *
 * @author Marcelo dos Santos
 *
 */
public class Proxy implements Subject {

  private final Subject realSubject;

  public Proxy(final Subject subject) {
    this.realSubject = subject;
  }

  @Override
  public String request() {
    return "[" + this.realSubject.request() + "]";
  }
}
