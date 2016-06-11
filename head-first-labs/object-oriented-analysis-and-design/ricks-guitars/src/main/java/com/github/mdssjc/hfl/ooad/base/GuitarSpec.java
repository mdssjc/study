package com.github.mdssjc.hfl.ooad.base;

import com.github.mdssjc.hfl.ooad.types.Builder;
import com.github.mdssjc.hfl.ooad.types.Type;
import com.github.mdssjc.hfl.ooad.types.Wood;

public class GuitarSpec {

  private Builder builder;
  private String  model;
  private Type    type;
  private int     numStrings;
  private Wood    backWood;
  private Wood    topWood;

  public GuitarSpec() {
  }

  public GuitarSpec(final Builder builder, final String model, final Type type,
      final int numStrings,
      final Wood backWood, final Wood topWood) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.numStrings = numStrings;
    this.backWood = backWood;
    this.topWood = topWood;
  }

  public Builder getBuilder() {
    return this.builder;
  }

  public void setBuilder(final Builder builder) {
    this.builder = builder;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(final String model) {
    this.model = model;
  }

  public Type getType() {
    return this.type;
  }

  public void setType(final Type type) {
    this.type = type;
  }

  public int getNumStrings() {
    return this.numStrings;
  }

  public void setNumStrings(final int numStrings) {
    this.numStrings = numStrings;
  }

  public Wood getBackWood() {
    return this.backWood;
  }

  public void setBackWood(final Wood backWood) {
    this.backWood = backWood;
  }

  public Wood getTopWood() {
    return this.topWood;
  }

  public void setTopWood(final Wood topWood) {
    this.topWood = topWood;
  }

  public boolean matches(final GuitarSpec otherSpec) {
    if (this.builder != otherSpec.builder) {
      return false;
    }
    if ((this.model != null) && (!this.model.equals(""))
        && (!this.model.equals(otherSpec.model))) {
      return false;
    }
    if (this.type != otherSpec.type) {
      return false;
    }
    if (this.numStrings != otherSpec.numStrings) {
      return false;
    }
    if (this.backWood != otherSpec.backWood) {
      return false;
    }
    if (this.topWood != otherSpec.topWood) {
      return false;
    }
    return true;
  }
}
