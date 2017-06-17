package com.github.mdssjc.ricksguitars;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

  private final List<Instrument> inventory;

  public Inventory() {
    this.inventory = new LinkedList();
  }

  public void addInstrument(final Instrument instrument) {
    this.inventory.add(instrument);
  }

  public Instrument get(final String serialNumber) {
    return this.inventory.stream()
                         .filter(i -> i.getSerialNumber()
                                       .equals(serialNumber))
                         .findFirst()
                         .orElse(null);
  }

  public Iterator<Instrument> search(final InstrumentSpec searchSpec) {
    final List<Instrument> matching = new LinkedList<>();

    for (final Instrument instrument : this.inventory) {
      if (instrument.getSpec()
                .equals(searchSpec)) {
        matching.add(instrument);
      }
    }
    return matching.iterator();
  }
}
