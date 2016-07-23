package com.github.mdssjc.hfooad.ricksguitars;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

import lombok.Data;

@Data
public class GuitarSpec extends InstrumentSpec {

  private int numStrings;

  public GuitarSpec(final Builder builder, final String model, final Type type,
      final int numStrings, final Wood backWood, final Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.numStrings = numStrings;
  }

  @Override
  public boolean matches(final InstrumentSpec otherSpec) {
    if (!super.matches(otherSpec)) {
      return false;
    }
    if (!(otherSpec instanceof GuitarSpec)) {
      return false;
    }
    return this.numStrings != ((GuitarSpec) otherSpec).numStrings;
  }
}
