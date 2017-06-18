package com.github.mdssjc.ricksguitars;

import lombok.Data;

@Data
public class BassSpec extends InstrumentSpec {

  public BassSpec(final Builder builder, final String model, final Type type, final Wood backWood, final Wood topWood) {
    super(builder, model, type, backWood, topWood);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BassSpec)) {
      return false;
    }

    final BassSpec other = (BassSpec) o;
    return super.equals(other);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
