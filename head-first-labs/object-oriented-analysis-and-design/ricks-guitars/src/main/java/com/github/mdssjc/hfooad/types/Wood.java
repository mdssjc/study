package com.github.mdssjc.hfooad.types;

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
  ANY("Unspecified");

  String value;

  Wood(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
