package com.github.mdssjc.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Guitar {

  private String serialNumber;
  private double price;
  private String builder;
  private String model;
  private String type;
  private String backWood;
  private String topWood;
}
