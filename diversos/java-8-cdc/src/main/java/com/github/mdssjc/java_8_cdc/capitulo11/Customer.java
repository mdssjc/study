package com.github.mdssjc.java_8_cdc.capitulo11;

public class Customer {

  private final String name;

  public Customer(final String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
