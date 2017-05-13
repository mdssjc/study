package com.github.mdssjc.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuitarSpec {

  public Builder builder;
  public String model;
  public Type type;
  public Wood backWood;
  public Wood topWood;
}
