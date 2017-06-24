package com.github.mdssjc.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instrument {

  private final String serialNumber;
  private double price;
  private final InstrumentSpec spec;
}
