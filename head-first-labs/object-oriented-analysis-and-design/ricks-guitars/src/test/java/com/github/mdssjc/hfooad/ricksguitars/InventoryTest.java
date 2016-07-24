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
        new InstrumentSpec()
          .addProperty("instrumentType", InstrumentType.GUITAR)
          .addProperty("builder", Builder.GIBSON)
          .addProperty("model", "Test")
          .addProperty("type", Type.ELECTRIC)
          .addProperty("numStrings", 6)
          .addProperty("backWood", Wood.BRAZILIAN_ROSEWOOD)
          .addProperty("topWood", Wood.BRAZILIAN_ROSEWOOD));

    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    inventory.add(guitar);

    final Instrument guitarResult = inventory.get(serialNumber);

    assertEquals(guitar, guitarResult);
  }

  @Test
  public void searchGuitar() {
    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    GuitarsTestDataBuilder.initializeInventory(inventory);

    final InstrumentSpec spec = new InstrumentSpec()
      .addProperty("instrumentType", InstrumentType.GUITAR)
      .addProperty("builder", Builder.FENDER)
      .addProperty("model", "Stratocastor")
      .addProperty("type", Type.ELECTRIC)
      .addProperty("numStrings", 6)
      .addProperty("backWood", Wood.ALDER)
      .addProperty("topWood", Wood.ALDER);

    final Iterator<Instrument> guitars = inventory.search(spec);
    final Instrument guitar1 = guitars.next();
    final Instrument guitar2 = guitars.next();
    final boolean hasNext = guitars.hasNext();

    assertEquals(GuitarsTestDataBuilder.GUITAR2, guitar1);
    assertEquals(GuitarsTestDataBuilder.GUITAR3, guitar2);
    assertFalse(hasNext);
  }
}
