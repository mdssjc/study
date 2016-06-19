package com.github.mdssjc.hfooad.base;

import com.github.mdssjc.hfooad.types.Builder;
import com.github.mdssjc.hfooad.types.Type;
import com.github.mdssjc.hfooad.types.Wood;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((this.backWood == null) ? 0 : this.backWood.hashCode());
    result = prime * result
        + ((this.builder == null) ? 0 : this.builder.hashCode());
    result = prime * result
        + ((this.model == null) ? 0 : this.model.hashCode());
    result = prime * result + this.numStrings;
    result = prime * result
        + ((this.topWood == null) ? 0 : this.topWood.hashCode());
    result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final GuitarSpec other = (GuitarSpec) obj;
    if (this.backWood != other.backWood) {
      return false;
    }
    if (this.builder != other.builder) {
      return false;
    }
    if (this.model == null) {
      if (other.model != null) {
        return false;
      }
    } else if (!this.model.equals(other.model)) {
      return false;
    }
    if (this.numStrings != other.numStrings) {
      return false;
    }
    if (this.topWood != other.topWood) {
      return false;
    }
    if (this.type != other.type) {
      return false;
    }
    return true;
  }
}
