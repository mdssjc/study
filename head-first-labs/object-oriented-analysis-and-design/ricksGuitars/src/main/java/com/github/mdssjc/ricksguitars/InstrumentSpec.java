package com.github.mdssjc.ricksguitars;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public abstract class InstrumentSpec {

  private Builder builder;
  private String model;
  private Type type;
  private Wood backWood;
  private Wood topWood;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof InstrumentSpec)) {
      return false;
    }

    InstrumentSpec other = (InstrumentSpec) o;
    return Objects.equals(builder, other.builder) &&
           Objects.equals(model, other.model) &&
           Objects.equals(type, other.type) &&
           Objects.equals(backWood, other.backWood) &&
           Objects.equals(topWood, other.topWood);
  }

  @Override
  public int hashCode() {
    return Objects.hash(builder, model, type, backWood, topWood);
  }
}
