package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Objects;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

/**
 * BanjoSpec Class.
 * 
 * @author Marcelo dos Santos
 *
 */
public class BanjoSpec extends InstrumentSpec {

  private final int numStrings;

  public BanjoSpec(final Builder builder, final String model,
      final int numStrings, final Type type, final Wood backWood,
      final Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.numStrings = numStrings;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BanjoSpec other = (BanjoSpec) obj;
    if (this.numStrings != other.numStrings) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.numStrings);
  }
}
