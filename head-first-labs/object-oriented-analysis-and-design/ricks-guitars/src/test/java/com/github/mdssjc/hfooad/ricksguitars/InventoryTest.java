package com.github.mdssjc.hfooad.ricksguitars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class InventoryTest {

  @Test
  public void addAndGetGuitar() {
    final String serialNumber = "12345";
    final Instrument guitar = new Instrument(serialNumber, 1250.00,
        InstrumentType.GUITAR,
        new GuitarSpec(Builder.GIBSON, "Test", Type.ELECTRIC, 6,
            Wood.BRAZILIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD));

    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    inventory.add(guitar);

    final Instrument guitarResult = inventory.get(serialNumber);

    assertEquals(guitar, guitarResult);
  }

  @Test
  public void searchGuitar() {
    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    GuitarsTestDataBuilder.initializeInventory(inventory);

    final InstrumentSpec spec = new GuitarSpec(Builder.FENDER,
        "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

    final Iterator<Instrument> guitars = inventory.search(spec);
    final Instrument guitar1 = guitars.next();
    final Instrument guitar2 = guitars.next();
    final boolean hasNext = guitars.hasNext();

    assertEquals(GuitarsTestDataBuilder.GUITAR2, guitar1);
    assertEquals(GuitarsTestDataBuilder.GUITAR3, guitar2);
    assertFalse(hasNext);
  }
}
