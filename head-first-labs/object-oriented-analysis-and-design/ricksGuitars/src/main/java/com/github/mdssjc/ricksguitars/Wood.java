package com.github.mdssjc.ricksguitars;

public enum Wood {

  INDIAN_ROSEWOOD("Indian Rosewood"),
  BRAZILIAN_ROSEWOOD("Brazilian Rosewood"),
  MAHOGANY("Mahogany"),
  MAPLE("Maple"),
  COCOBOLO("Cocobolo"),
  CEDAR("Cedar"),
  ADIRONDACK("Adirondack"),
  ALDER("Alder"),
  SITKA("Sitka"),
  UNSPECIFIED("unspecified");

  private final String value;

  Wood(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
