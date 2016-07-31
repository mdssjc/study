package com.github.mdssjc.hfooad.ricksguitars;

import java.util.Iterator;
import java.util.function.Consumer;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class FindInstrument {

  public static void main(final String[] args) {
    final Inventory<Instrument, InstrumentSpec> inventory = new Inventory<>();
    InstrumentsTestDataBuilder.initializeInventory(inventory);

    final InstrumentSpec clientSpec = new InstrumentSpec()
      .addProperty("builder", Builder.GIBSON)
      .addProperty("backWood", Wood.MAPLE);

    final Iterator<Instrument> matching = inventory.search(clientSpec);
    if (matching.hasNext()) {
      System.out.println("You might like these instruments:");
      matching.forEachRemaining(formatMessage());
    } else {
      System.out.println("Sorry, we have nothing for you.");
    }
  }

  private static Consumer<? super Instrument> formatMessage() {
    return (instrument) -> {
      final InstrumentSpec spec = instrument.getSpec();
      System.out.println("We have a " + spec.getProperty("instrumentType")
          + " with the following properties:");

      spec.getProperties()
        .forEachRemaining(p -> {
          if (!p.equals("instrumentType")) {
            System.out.println(" " + p + ": " + spec.getProperty(p));
          }
        });
      System.out.println(" You can have this " +
          spec.getProperty("instrumentType") + " for $" +
          instrument.getPrice() + "\n---");
    };
  }
}
