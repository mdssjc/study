package com.github.mdssjc.dogdoors;

import java.util.Objects;

public class Bark {

  private final String sound;

  public Bark(final String sound) {
    this.sound = sound;
  }

  public String getSound() {
    return this.sound;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.sound);
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }
    final Bark other = (Bark) object;
    return this.sound.equalsIgnoreCase(other.getSound());
  }
}
