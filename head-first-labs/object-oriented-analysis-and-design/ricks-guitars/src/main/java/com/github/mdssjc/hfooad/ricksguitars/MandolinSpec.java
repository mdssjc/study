package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Objects;

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
    final MandolinSpec other = (MandolinSpec) obj;
    if (this.style != other.style) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.style);
  }
}
