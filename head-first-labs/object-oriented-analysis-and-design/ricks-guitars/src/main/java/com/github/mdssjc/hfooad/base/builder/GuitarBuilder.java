package com.github.mdssjc.hfooad.base.builder;

import com.github.mdssjc.hfooad.base.Guitar;
import com.github.mdssjc.hfooad.base.GuitarSpec;
import com.github.mdssjc.hfooad.types.Builder;
import com.github.mdssjc.hfooad.types.Type;
import com.github.mdssjc.hfooad.types.Wood;

// FIXME ver Lombok.
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

  public Guitar makeGuitar() {
    return new Guitar(this.serialNumber, this.price,
        new GuitarSpec(this.builder, this.model, this.type, this.numStrings,
            this.backWood, this.topWood));
  }
}
