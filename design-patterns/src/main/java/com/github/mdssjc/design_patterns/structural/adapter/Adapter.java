package com.github.mdssjc.design_patterns.creational.adapter;

/**
 * Adapter.
 *
 * @author Marcelo dos Santos
 *
 */
public class Adapter implements Target {

  private final Adaptee adaptee;

  public Adapter(final Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public String request() {
    return this.adaptee.specificRequest();
  }
}
