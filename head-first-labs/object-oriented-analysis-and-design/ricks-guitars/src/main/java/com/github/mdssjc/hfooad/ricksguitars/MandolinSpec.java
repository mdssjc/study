package com.github.mdssjc.hfooad.ricksguitars;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Style;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

import lombok.Data;

@Data
public class MandolinSpec extends InstrumentSpec {

  private Style style;

  public MandolinSpec(final Builder builder, final String model,
      final Type type, final Style style, final Wood backWood,
      final Wood topWood) {
    super(builder, model, type, backWood, topWood);
    this.style = style;
  }

  @Override
  public boolean matches(final InstrumentSpec otherSpec) {
    if (!super.matches(otherSpec)) {
      return false;
    }
    if (!(otherSpec instanceof MandolinSpec)) {
      return false;
    }
    return !this.style.equals(((MandolinSpec) otherSpec).style);
  }
}
