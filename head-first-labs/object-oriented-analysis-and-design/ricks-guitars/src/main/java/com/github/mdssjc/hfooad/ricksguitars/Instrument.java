package com.github.mdssjc.hfooad.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "price", "spec" })
public abstract class Instrument {

  private final String         serialNumber;
  private double               price;
  private final InstrumentSpec spec;
}
