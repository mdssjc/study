package com.github.mdssjc.ricksguitars;

public enum Builder {

  FENDER("Fender"),
  MARTIN("Martin"),
  GIBSON("Gibson"),
  COLLINGS("Collings"),
  OLSON("Olson"),
  RYAN("Ryan"),
  PRS("PRS"),
  ANY("unspecified");

  private final String value;

  Builder(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
