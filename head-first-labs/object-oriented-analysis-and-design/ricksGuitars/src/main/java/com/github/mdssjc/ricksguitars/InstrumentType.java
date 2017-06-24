package com.github.mdssjc.ricksguitars;

public enum InstrumentType {
  GUITAR("Guitar"),
  BANJO("Banjo"),
  DOBRO("Dobro"),
  FIDDLE("Fiddle"),
  BASS("Bass"),
  MANDOLIN("Mandolin"),
  UNSPECIFIED("Unspecified");

  private final String instrument;

  InstrumentType(final String instrument) {
    this.instrument = instrument;
  }

  @Override
  public String toString() {
    return this.instrument;
  }
}
