package com.github.mdssjc.ricksguitars;

import lombok.Data;

import java.util.Objects;

@Data
public class GuitarSpec extends InstrumentSpec {

  private int numStrings;

  public GuitarSpec(Builder builder, String model, Type type,
                    int numStrings, Wood backWood, Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.numStrings = numStrings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof GuitarSpec)) {
      return false;
    }

    GuitarSpec other = (GuitarSpec) o;
    return super.equals(other) &&
           Objects.equals(numStrings, other.numStrings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numStrings);
  }
}
