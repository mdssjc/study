package com.github.mdssjc.hfooad.ricksguitars.builder;

import com.github.mdssjc.hfooad.ricksguitars.Guitar;
import com.github.mdssjc.hfooad.ricksguitars.GuitarSpec;
import com.github.mdssjc.hfooad.ricksguitars.Instrument;
import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class GuitarBuilder {

  private String  serialNumber;
  private double  price;
  private Builder builder;
  private String  model;
  private Type    type;
  private int     numStrings;
  private Wood    backWood;
  private Wood    topWood;

  public GuitarBuilder() {
  }

  public GuitarBuilder setSerialNumber(final String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  public GuitarBuilder setPrice(final double price) {
    this.price = price;
    return this;
  }

  public GuitarBuilder setBuilder(final Builder builder) {
    this.builder = builder;
    return this;
  }

  public GuitarBuilder setModel(final String model) {
    this.model = model;
    return this;
  }

  public GuitarBuilder setType(final Type type) {
    this.type = type;
    return this;
  }

  public GuitarBuilder setNumStrings(final int numStrings) {
    this.numStrings = numStrings;
    return this;
  }

  public GuitarBuilder setBackWood(final Wood backWood) {
    this.backWood = backWood;
    return this;
  }

  public GuitarBuilder setTopWood(final Wood topWood) {
    this.topWood = topWood;
    return this;
  }

  public Instrument makeGuitar() {
    return new Guitar(this.serialNumber, this.price,
        new GuitarSpec(this.builder, this.model, this.type, this.numStrings,
            this.backWood, this.topWood));
  }
}
