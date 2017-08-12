package com.github.mdssjc.routefinder.subway;

import lombok.Data;

@Data
public class Station {

  private final String name;

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Station)) {
      return false;
    }
    final Station other = (Station) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equalsIgnoreCase(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return this.name.toLowerCase()
                    .hashCode();
  }
}
