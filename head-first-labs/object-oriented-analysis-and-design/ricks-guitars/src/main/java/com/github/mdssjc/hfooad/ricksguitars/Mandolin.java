package com.github.mdssjc.hfooad.ricksguitars;

public class Mandolin extends Instrument {

  public Mandolin(String serialNumber, double price, MandolinSpec spec) {
    super(serialNumber, price, spec);
  }

  public boolean matches(final MandolinSpec other) {
    return getSpec().matches(other);
  }
}
