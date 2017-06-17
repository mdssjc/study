package com.github.mdssjc.ricksguitars;

import lombok.Data;

import java.util.Objects;

@Data
public class MandolinSpec extends InstrumentSpec {

  private Style style;

  public MandolinSpec(Builder builder, String model, Type type,
                      Style style, Wood backWood, Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.style = style;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof MandolinSpec)) {
      return false;
    }

    MandolinSpec other = (MandolinSpec) o;
    return super.equals(other) &&
           Objects.equals(style, other.style);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), style);
  }
}
