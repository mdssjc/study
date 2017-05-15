package com.github.mdssjc.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuitarSpec {

  private Builder builder;
  private String model;
  private Type type;
  private int numStrings;
  private Wood backWood;
  private Wood topWood;
}
