package com.github.mdssjc.hfooad;

import java.util.Iterator;
import java.util.function.Consumer;

import com.github.mdssjc.hfooad.base.Guitar;
import com.github.mdssjc.hfooad.base.GuitarSpec;
import com.github.mdssjc.hfooad.base.Inventory;
import com.github.mdssjc.hfooad.types.Builder;
import com.github.mdssjc.hfooad.types.Type;
import com.github.mdssjc.hfooad.types.Wood;

public class FindGuitarTester {

  public static void main(final String[] args) {
    final Inventory<Guitar, GuitarSpec> inventory = new Inventory<>();
    GuitarsTestDataBuilder.initializeInventory(inventory);

    final GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER,
        "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

    final Iterator<Guitar> matchingGuitars = inventory.search(whatErinLikes);
    if (matchingGuitars.hasNext()) {
      System.out.println("Erin, you might like these guitars:");
      matchingGuitars.forEachRemaining(formatMessage());
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static Consumer<? super Guitar> formatMessage() {
    return (guitar) -> {
      final GuitarSpec spec = guitar.getSpec();
      System.out.println("  We have a " + spec.getBuilder() + " "
          + spec.getModel() + " " + spec.getType()
          + " guitar:\n     " + spec.getBackWood()
          + " back and sides,\n     " + spec.getTopWood()
          + " top.\n  You can have it for only $"
          + guitar.getPrice() + "!\n  ----");
    };
  }
}
