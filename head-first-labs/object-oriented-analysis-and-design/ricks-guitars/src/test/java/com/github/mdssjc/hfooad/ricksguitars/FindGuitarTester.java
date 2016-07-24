package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Iterator;
import java.util.function.Consumer;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.InstrumentType;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class FindGuitarTester {

  public static void main(final String[] args) {
    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    GuitarsTestDataBuilder.initializeInventory(inventory);

    final InstrumentSpec whatErinLikes = new InstrumentSpec()
      .addProperty("instrumentType", InstrumentType.GUITAR)
      .addProperty("builder", Builder.FENDER)
      .addProperty("model", "Stratocastor")
      .addProperty("type", Type.ELECTRIC)
      .addProperty("numStrings", 6)
      .addProperty("backWood", Wood.ALDER)
      .addProperty("topWood", Wood.ALDER);

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
      final InstrumentSpec spec = guitar.getSpec();
      System.out.println("  We have a " + spec.getProperty("builder") + " "
          + spec.getProperty("model") + " " + spec.getProperty("type")
          + " guitar:\n     " + spec.getProperty("backWood")
          + " back and sides,\n     " + spec.getProperty("topWood")
          + " top.\n  You can have it for only $"
          + guitar.getPrice() + "!\n  ----");
    };
  }
}
