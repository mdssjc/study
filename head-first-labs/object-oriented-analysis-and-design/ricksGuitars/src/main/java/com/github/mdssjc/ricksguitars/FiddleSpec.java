package com.github.mdssjc.ricksguitars;

import lombok.Data;

import java.util.Objects;

@Data
public class FiddleSpec extends InstrumentSpec {

  private String finish;

  public FiddleSpec(final Builder builder, final String model, final Type type, final String finish, final Wood backWood, final Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.finish = finish;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof FiddleSpec)) {
      return false;
    }

    final FiddleSpec other = (FiddleSpec) o;
    return super.equals(other) &&
           Objects.equals(this.finish, other.finish);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.finish);
  }
}
