package com.github.mdssjc.ricksguitars;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

  private final List<Instrument> inventory;

  public Inventory() {
    this.inventory = new LinkedList<>();
  }

  public void addInstrument(final String serialNumber, final double price, final InstrumentSpec spec) {
    this.inventory.add(new Instrument(serialNumber, price, spec));
  }

  public Instrument get(final String serialNumber) {
    return this.inventory.stream()
                         .filter(i -> i.getSerialNumber()
                                       .equals(serialNumber))
                         .findFirst()
                         .orElse(null);
  }

  public Iterator<Instrument> search(final InstrumentSpec searchSpec) {
    return this.inventory.stream()
                         .filter(i -> i.getSpec()
                                       .equals(searchSpec))
                         .collect(Collectors.toCollection(LinkedList::new))
                         .iterator();
  }
}
