package com.github.mdssjc.gsf.util;

public class UnitIDGenerator extends IDGenerator {

  private final static UnitIDGenerator defaultUnitIDGenerator =
      new UnitIDGenerator();

  public UnitIDGenerator() {
    this("UNIT", 1000);
  }

  public UnitIDGenerator(final String prefix, final int startIDNumber) {
    this.prefix = prefix;
    this.nextUnitIDNumber = startIDNumber;
  }

  public static UnitIDGenerator getDefaultUnitIDGenerator() {
    return defaultUnitIDGenerator;
  }
}
