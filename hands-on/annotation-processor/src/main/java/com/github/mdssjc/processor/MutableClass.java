package com.github.mdssjc.processor;

@Immutable
public class MutableClass {

  private final String name;

  public MutableClass(final String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
