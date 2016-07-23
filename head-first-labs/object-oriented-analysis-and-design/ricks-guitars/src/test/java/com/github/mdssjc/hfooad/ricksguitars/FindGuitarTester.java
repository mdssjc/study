package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Iterator;
import java.util.function.Consumer;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class FindGuitarTester {

  public static void main(final String[] args) {
    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    GuitarsTestDataBuilder.initializeInventory(inventory);

    final GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER,
        "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

    final Iterator<Instrument> matchingGuitars = inventory.search(
        whatErinLikes);
    if (matchingGuitars.hasNext()) {
      System.out.println("Erin, you might like these guitars:");
      matchingGuitars.forEachRemaining(formatMessage());
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static Consumer<? super Instrument> formatMessage() {
    return (guitar) -> {
      final GuitarSpec spec = (GuitarSpec) guitar.getSpec();
      System.out.println("  We have a " + spec.getBuilder() + " "
          + spec.getModel() + " " + spec.getType()
          + " guitar:\n     " + spec.getBackWood()
          + " back and sides,\n     " + spec.getTopWood()
          + " top.\n  You can have it for only $"
          + guitar.getPrice() + "!\n  ----");
    };
  }
}
