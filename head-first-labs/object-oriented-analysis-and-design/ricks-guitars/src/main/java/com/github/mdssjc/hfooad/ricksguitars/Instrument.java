package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Instrument Class.
 * 
 * @author Marcelo dos Santos
 *
 */
@Data
@AllArgsConstructor
@Builder
public class Instrument {

  private final String         serialNumber;
  private double               price;
  private final InstrumentSpec spec;

  @Override
  public int hashCode() {
    return Objects.hash(this.serialNumber, this.price, this.spec);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      if (obj instanceof String) {
        return ((String) obj).equals(this.serialNumber);
      } else if (obj instanceof InstrumentSpec) {
        return getSpec().equals(obj);
      }
      return false;
    }
    final Instrument other = (Instrument) obj;
    if (!Objects.equals(this.serialNumber, other.serialNumber)) {
      return false;
    } else if (!Objects.equals(this.price, other.price)) {
      return false;
    } else if (!Objects.equals(this.spec, other.spec)) {
      return false;
    }
    return true;
  }
}
