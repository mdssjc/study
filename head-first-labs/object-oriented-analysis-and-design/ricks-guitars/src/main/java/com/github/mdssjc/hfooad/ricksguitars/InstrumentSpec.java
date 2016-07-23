package com.github.mdssjc.hfooad.ricksguitars;

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

  public boolean matches(InstrumentSpec otherSpec) {
    if (this.builder != otherSpec.builder) {
      return false;
    }
    if ((this.model != null) && (!this.model.equals(""))
        && (!this.model.equals(otherSpec.model))) {
      return false;
    }
    if (this.type != otherSpec.type) {
      return false;
    }
    if (this.backWood != otherSpec.backWood) {
      return false;
    }
    if (this.topWood != otherSpec.topWood) {
      return false;
    }
    return true;
  }
}
