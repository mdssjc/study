package com.github.mdssjc.hfooad.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Instrument {

  private final String         serialNumber;
  private double               price;
  private final InstrumentSpec spec;
}
