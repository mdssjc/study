package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Objects;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

import lombok.Data;

/**
 * GuitarSpec Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@Data
public class GuitarSpec extends InstrumentSpec {

  private int numStrings;

  public GuitarSpec(final Builder builder, final String model, final Type type,
      final int numStrings, final Wood backWood, final Wood topWood) {
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
    final GuitarSpec other = (GuitarSpec) obj;
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
