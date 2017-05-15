package com.github.mdssjc.ricksguitars;

public enum Type {

  ACOUSTIC("acoustic"),
  ELECTRIC("electric"),
  UNSPECIFIED("unspecified");

  private final String value;

  Type(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
