package com.github.mdssjc.ricksguitars;

import lombok.Data;

import java.util.Objects;

@Data
public class BanjoSpec extends InstrumentSpec {

  private int numStrings;

  public BanjoSpec(final Builder builder, final String model, final Type type, final int numStrings, final Wood backWood, final Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.numStrings = numStrings;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BanjoSpec)) {
      return false;
    }

    final BanjoSpec other = (BanjoSpec) o;
    return super.equals(other) &&
           Objects.equals(this.numStrings, other.numStrings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numStrings);
  }
}
