package com.github.mdssjc.gsf.util;

public abstract class IDGenerator {

  protected int nextUnitIDNumber = 1000;
  protected String prefix = "";

  public String nextUnitID() {
    return this.prefix + (this.nextUnitIDNumber++);
  }
}
