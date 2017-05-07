package com.github.mdssjc.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Guitar {

  private String serialNumber;
  private double price;
  private Builder builder;
  private String model;
  private Type type;
  private Wood backWood;
  private Wood topWood;
}
