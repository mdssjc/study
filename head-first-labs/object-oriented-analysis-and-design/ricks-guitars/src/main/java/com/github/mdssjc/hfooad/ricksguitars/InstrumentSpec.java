package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Objects;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class InstrumentSpec {

  private Builder builder;
  private String  model;
  private Type    type;
  private Wood    backWood;
  private Wood    topWood;

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final InstrumentSpec other = (InstrumentSpec) obj;
    if (!Objects.equals(this.builder, other.builder)) {
      return false;
    } else if (!Objects.equals(this.model, other.model)) {
      return false;
    } else if (!Objects.equals(this.type, other.type)) {
      return false;
    } else if (!Objects.equals(this.backWood, other.backWood)) {
      return false;
    } else if (!Objects.equals(this.topWood, other.topWood)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.builder, this.model, this.type, this.backWood,
        this.topWood);
  }
}
