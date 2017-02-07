package com.github.mdssjc.dp.adapter.adapter;

import com.github.mdssjc.dp.adapter.adaptee.Adaptee;

/**
 * Classe Adapter.
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
  public void request() {
    this.adaptee.specificRequest();
  }
}
