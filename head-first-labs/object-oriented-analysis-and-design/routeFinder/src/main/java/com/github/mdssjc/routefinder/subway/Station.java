package com.github.mdssjc.routefinder.subway;

public class Station {

  private final String name;

  public Station(final String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
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
