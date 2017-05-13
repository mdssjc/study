package com.github.mdssjc.ricksguitars;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

  private final List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
    Guitar guitar = new Guitar(serialNumber, price, spec);
    guitars.add(guitar);
  }

  public Guitar getGuitar(String serialNumber) {
    for (Guitar guitar : guitars) {
      if (guitar.getSerialNumber()
                .equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  public List<Guitar> search(GuitarSpec searchGuitar) {
    List<Guitar> matchingGuitars = new LinkedList<>();

    for (Guitar guitar : guitars) {
      if (guitar.getSpec()
                .equals(searchGuitar)) {
        matchingGuitars.add(guitar);
      }
    }
    return matchingGuitars;
  }
}
