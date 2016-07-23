package com.github.mdssjc.hfooad.ricksguitars;

public class Guitar extends Instrument {

  public Guitar(final String serialNumber, final double price,
      final InstrumentSpec spec) {
    super(serialNumber, price, spec);
  }

  public boolean matches(final GuitarSpec other) {
    return getSpec().matches(other);
  }
}
