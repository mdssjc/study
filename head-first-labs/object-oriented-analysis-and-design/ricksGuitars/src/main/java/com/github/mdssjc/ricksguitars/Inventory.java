package com.github.mdssjc.ricksguitars;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

  private List guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    Guitar guitar = new Guitar(serialNumber, price,
                               new GuitarSpec(builder, model, type, backWood,
                                              topWood));
    guitars.add(guitar);
  }

  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar) i.next();
      if (guitar.getSerialNumber()
                .equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  public List<Guitar> search(GuitarSpec searchGuitar) {
    List<Guitar> matchingGuitars = new LinkedList<>();

    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar) i.next();
      GuitarSpec guitarSpec = guitar.getSpec();

      if (searchGuitar.getBuilder() != guitarSpec.getBuilder()) {
        continue;
      }

      String model = searchGuitar.getModel()
                                 .toLowerCase();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitarSpec.getModel()
                                   .toLowerCase()))) {
        continue;
      }

      if (searchGuitar.getType() != guitarSpec.getType()) {
        continue;
      }

      if (searchGuitar.getBackWood() != guitarSpec.getBackWood()) {
        continue;
      }

      if (searchGuitar.getTopWood() != guitarSpec.getTopWood()) {
        continue;
      }
      matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
}
