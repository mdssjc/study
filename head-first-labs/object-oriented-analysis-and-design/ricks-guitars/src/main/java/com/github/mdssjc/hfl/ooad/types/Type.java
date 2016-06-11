package com.github.mdssjc.hfl.ooad.types;

public enum Type {

  ACOUSTIC,
  ELECTRIC;

  @Override
  public String toString() {
    switch (this) {
      case ACOUSTIC:
        return "acoustic";
      case ELECTRIC:
        return "electric";
      default:
        return "unspecified";
    }
  }
}
