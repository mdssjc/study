package com.github.mdssjc.hfooad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

import com.github.mdssjc.hfooad.base.Guitar;
import com.github.mdssjc.hfooad.base.GuitarSpec;
import com.github.mdssjc.hfooad.base.Inventory;
import com.github.mdssjc.hfooad.types.Builder;
import com.github.mdssjc.hfooad.types.Type;
import com.github.mdssjc.hfooad.types.Wood;

public class InventoryTest {

  @Test
  public void addAndGetGuitar() {
    final String serialNumber = "12345";
    final Guitar guitar = new Guitar(serialNumber, 1250.00,
        new GuitarSpec(Builder.GIBSON, "Test", Type.ELECTRIC, 6,
            Wood.BRAZILIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD));

    final Inventory<Guitar, GuitarSpec> inventory = new Inventory<>();
    inventory.add(guitar);

    final Guitar guitarResult = inventory.get(serialNumber);

    assertEquals(guitar, guitarResult);
  }

  @Test
  public void searchGuitar() {
    final Inventory<Guitar, GuitarSpec> inventory = new Inventory<>();
    GuitarsTestDataBuilder.initializeInventory(inventory);

    final GuitarSpec spec = new GuitarSpec(Builder.FENDER,
        "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

    final Iterator<Guitar> guitars = inventory.search(spec);
    final Guitar guitar1 = guitars.next();
    final Guitar guitar2 = guitars.next();
    final boolean hasNext = guitars.hasNext();

    assertEquals(GuitarsTestDataBuilder.GUITAR2, guitar1);
    assertEquals(GuitarsTestDataBuilder.GUITAR3, guitar2);
    assertFalse(hasNext);
  }
}
