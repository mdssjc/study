package com.github.mdssjc.hfooad.ricksguitars.types;

public enum Type {

  ACOUSTIC("Acoustic"),
  ELECTRIC("Electric"),
  ANY("Unspecified");

  String value;

  Type(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
