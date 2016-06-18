package com.github.mdssjc.hfl.ooad.base;

import com.github.mdssjc.hfl.ooad.types.Builder;
import com.github.mdssjc.hfl.ooad.types.Type;
import com.github.mdssjc.hfl.ooad.types.Wood;

import lombok.Getter;
import lombok.Setter;

public class GuitarSpec {

  @Getter
  @Setter
  private Builder builder;
  @Getter
  @Setter
  private String  model;
  @Getter
  @Setter
  private Type    type;
  @Getter
  @Setter
  private int     numStrings;
  @Getter
  @Setter
  private Wood    backWood;
  @Getter
  @Setter
  private Wood    topWood;

  public GuitarSpec() {
  }

  public GuitarSpec(final Builder builder, final String model, final Type type,
      final int numStrings, final Wood backWood, final Wood topWood) {
    this.builder = builder;
    this.model = model;
    this.type = type;
    this.numStrings = numStrings;
    this.backWood = backWood;
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
